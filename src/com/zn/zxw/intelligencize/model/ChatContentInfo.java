
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:����������Ϣ�����ݺ��ļ�
	*/
    public class ChatContentInfo implements Serializable
    {
        public ChatContentInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _chatContentID;//�߼����
		/**
		*����
		*/
		private String   _groupID;//����
		/**
		*��������
		*/
		private String   _content;//��������
		/**
		*ͼƬ
		*/
		private String   _pictureListId;//ͼƬ
		/**
		*����ʱ��
		*/
		private String   _date;//����ʱ��
		/**
		*״̬
		*/
		private String   _state;//״̬
		/**
		*�Ƿ���Իظ�(0=false,1=true)
		*/
		private int   _ifReply;//�Ƿ���Իظ�(0=false,1=true)
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ChatGroupInfo  _chatGroupInfo;
		
		//list FK
 private List<ChatAcceptInfo> _chatAcceptInfos;
		
		
		
		
		/**
		*���
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*���
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*�߼����
		*/
		public String getChatContentID()
		{
		
			 return _chatContentID; 
		}
		/**
		*�߼����
		*/
		public void  setChatContentID (String  ChatContentID )
		{
			_chatContentID = ChatContentID ;
		}
		
		
		/**
		*����
		*/
		public String getGroupID()
		{
		
			 return _groupID; 
		}
		/**
		*����
		*/
		public void  setGroupID (String  GroupID )
		{
			_groupID = GroupID ;
		}
		
		
		/**
		*��������
		*/
		public String getContent()
		{
		
			 return _content; 
		}
		/**
		*��������
		*/
		public void  setContent (String  Content )
		{
			_content = Content ;
		}
		
		
		/**
		*ͼƬ
		*/
		public String getPictureListId()
		{
		
			 return _pictureListId; 
		}
		/**
		*ͼƬ
		*/
		public void  setPictureListId (String  PictureListId )
		{
			_pictureListId = PictureListId ;
		}
		
		
		/**
		*����ʱ��
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*����ʱ��
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*�Ƿ���Իظ�(0=false,1=true)
		*/
		public int getIfReply()
		{
		
			 return _ifReply; 
		}
		/**
		*�Ƿ���Իظ�(0=false,1=true)
		*/
		public void  setIfReply (int  IfReply )
		{
			_ifReply = IfReply ;
		}
		
		
		/**
		*Ԥ���ֶ�
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*Ԥ���ֶ�
		*/
		public void  setField (String  Field )
		{
			_field = Field ;
		}
		
	
		
		
		
		public ChatGroupInfo  getChatGroupInfo()
		{
		return _chatGroupInfo;
		}
		
		public void  setChatGroupInfo(ChatGroupInfo  ChatGroupInfo)
		{
		 _chatGroupInfo =ChatGroupInfo;
		
		}
		
		
				//list FK
     		public List< ChatAcceptInfo>  getChatAcceptInfos()
		{
		return _chatAcceptInfos;
		}
		
		public void  setChatAcceptInfos(List<ChatAcceptInfo>  ChatAcceptInfos)
		{
		 _chatAcceptInfos =ChatAcceptInfos;
		
		}
    }
 
	
		



