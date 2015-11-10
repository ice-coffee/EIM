package com.zn.zxw.intelligencize.model;

import java.io.Serializable;

public class JsonEntity implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private  String entityName;
		private  String sendUser;
		private  String acceptUser;
		private String sendDate;
		private String entityId;
		private String content;
	
		private String title;
		private String webContent;
		public JsonEntity(){}
		
		/**
		 * 
		 * @param entityName
		 * @param sendUser
		 * @param acceptUser
		 * @param sendDate
		 * @param entityId
		 * @param content
		 * @param title
		 * @param webContent
		 */
		public JsonEntity(String entityName, String sendUser,
				String acceptUser, String sendDate, String entityId,
				String content, String title, String webContent) {
			super();
			this.entityName = entityName;
			this.sendUser = sendUser;
			this.acceptUser = acceptUser;
			this.sendDate = sendDate;
			this.entityId = entityId;
			this.content = content;
			this.title = title;
			this.webContent = webContent;
		}
		/** 
		 * 鑾峰彇web鏍煎紡鍐呭
		 * @return
		 */
		public String getWebContent() {
			return webContent;
		}
		/**
		 * 璁剧疆web鏍煎紡鍐呭
		 * @return
		 */
		public void setWebContent(String webContent) {
			this.webContent = webContent;
		}
		/**
		 * 鑾峰彇琛ㄥ悕绉�
		 * @return
		 */
		public String getEntityName() {
			return entityName;
		}
		/**
		 * 璁剧疆琛ㄥ悕绉�
		 * @param entityName
		 */
		public void setEntityName(String entityName) {
			this.entityName = entityName;
		}
		/**
		 * 璁剧疆琛ㄥ悕绉�
		 * @param entityName
		 */
		public void setEntityName(TableName entityName) {
			this.entityName = entityName.toString();
		}
		public String getSendUser() {
			return sendUser;
		}
		public void setSendUser(String sendUser) {
			this.sendUser = sendUser;
		}
		public String getAcceptUser() {
			return acceptUser;
		}
		public void setAcceptUser(String acceptUser) {
			this.acceptUser = acceptUser;
		}
		public String getSendDate() {
			return sendDate;
		}
		public void setSendDate(String sendDate) {
			this.sendDate = sendDate;
		}
		/**
		 * 琛ㄤ富閿甶d
		 * @return
		 */
		public String getEntityId() {
			if(entityId==null)
				return "";
			return entityId;
		}
		/**
		 * 琛ㄤ富閿甶d
		 * @return
		 */
		public void setEntityId(String entityId) {
			this.entityId = entityId;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

	
}
