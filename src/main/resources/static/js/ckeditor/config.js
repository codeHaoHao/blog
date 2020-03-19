/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	// 上传图片窗口用到的接口
    config.filebrowserImageUploadUrl = "/imageUpload";
    config.filebrowserUploadUrl = "/imageUpload";

    // 使上传图片弹窗出现对应的“上传”tab标签
    config.removeDialogTabs = 'image:advanced;link:advanced';

    // 粘贴图片时用得到
    config.extraPlugins = 'uploadimage';
    config.uploadUrl = '/imageUpload';
    config.image_previewText=' ';     //预览区域显示内容   
};
