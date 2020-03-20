package com.lijiahao.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lijiahao.blog.dao.ArticleDao;
import com.lijiahao.blog.dao.cache.ArticleCache;
import com.lijiahao.blog.dao.cache.IpCache;
import com.lijiahao.blog.model.Article;
import com.lijiahao.blog.model.ArticleTags;
import com.lijiahao.blog.model.Tags;
import com.lijiahao.blog.service.ArticleService;
import com.lijiahao.blog.service.ArticleTagsService;
import com.lijiahao.blog.service.TagsService;

@Service("ArticleService")
public class ArticleServiceImpl extends GenericServiceImpl<Article> implements ArticleService{
	
	@Autowired
	private ArticleDao dao;
	
	@Autowired
	private ArticleCache cache;
	
	@Autowired
	private IpCache ipCache;
	
	@Autowired
	private TagsService tagsService;
	
	@Autowired
	private ArticleTagsService articleTagsService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDao(dao);
		this.setCache(cache);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int addArticle(Article article, String tags) {

		String[] tags_arr = tags.split(",");
		add(article);
		int article_id = article.getId();
		for (int i = 0; i < tags_arr.length; i++) {
			String tag_s = tags_arr[i];
			Tags select = new Tags();
			select.setName(tag_s);
			Tags tag = tagsService.selectByBean(select);
			int tags_id = -1;
			if (tag == null) {
				tags_id = tagsService.add(select);
			} else {
				tags_id = tag.getId();
			}
			ArticleTags add = new ArticleTags(article_id, tags_id);
			articleTagsService.add(add);
		}

		return article_id;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateArticle(Article article, String tags) {
		
		String[] tags_arr = tags.split(",");
		int article_id = article.getId();
		articleTagsService.deleteByArticleId(article_id);
		if(tags != null && !tags.isEmpty()) {
			for (int i = 0; i < tags_arr.length; i++) {
				String tag_s = tags_arr[i];
				Tags select = new Tags();
				select.setName(tag_s);
				Tags tag = tagsService.selectByBean(select);
				int tags_id = -1;
				if (tag == null) {
					tags_id = tagsService.add(select);
				} else {
					tags_id = tag.getId();
				}
				ArticleTags add = new ArticleTags(article_id, tags_id);
				articleTagsService.add(add);
			}
		}
		
		int id = update(article);
		return 0;
	}

	@Override
	public PageInfo<Article> getListOrderByReadings() {
		PageHelper.startPage(1, Integer.MAX_VALUE, "readings desc");
		List<Article> list = dao.getList();
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<Article> getListOrderByCreateDate(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, "create_date desc");
		List<Article> list = dao.getList();
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		return pageInfo;
	}

	@Override
	public Article getPrevious(int id) {
		int previous_id = -1;
		try {
			previous_id = dao.getPrevious(id);
		}catch (Exception e) {
			return new Article();
		}
		return get(previous_id);
	}

	@Override
	public Article getNext(int id) {
		int next_id = -1;
		try {
			next_id = dao.getNext(id);
		}catch (Exception e) {
			return new Article();
		}
		
		return get(next_id);
	}

	@Override
	public int updateReadings(Article article, String ip) {
		if(ipCache.canUpdateReadings(ip, article.getId())) {
			int readings = article.getReadings() + 1;
			article.setReadings(readings);
			dao.update(article);
		}
		return 0;
	}

	

}
