
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼��������������е����ּ�¼
   ���Զ���Ʒ���̼ң��ˣ����ж��󶼿��Խ������ۣ������˵ĳ��࣬Ʒζ��������
	*/
    public class ScoreTypeListInfo implements Serializable
    {
        public ScoreTypeListInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*���ֶ���
		*/
		private String   _oSId;//���ֶ���
		/**
		*������
		*/
		private String   _userId;//������
		/**
		*��ַ���
		*/
		private int   _score;//��ַ���
		/**
		*����ʱ��
		*/
		private String   _date;//����ʱ��
		/**
		*����
		*/
		private String _comment;
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		private  ObjectScoreInfo  _objectScoreInfo;
		
		//list FK
		
		
		
		
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
		*���ֶ���
		*/
		public String getOSId()
		{
		
			 return _oSId; 
		}
		/**
		*���ֶ���
		*/
		public void  setOSId (String  OSId )
		{
			_oSId = OSId ;
		}
		
		
		/**
		*������
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*������
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*��ַ���
		*/
		public int getScore()
		{
		
			 return _score; 
		}
		/**
		*��ַ���
		*/
		public void  setScore (int  Score )
		{
			_score = Score ;
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
		*����
		*/
		public String getComment()
		{
		
			 return _comment;
		}
		/**
		*����
		*/
		public void  setComment (String  comment)
		{
			_comment= comment;;
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
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		public ObjectScoreInfo  getObjectScoreInfo()
		{
		return _objectScoreInfo;
		}
		
		public void  setObjectScoreInfo(ObjectScoreInfo  ObjectScoreInfo)
		{
		 _objectScoreInfo =ObjectScoreInfo;
		
		}
		
		
				//list FK
  }
 
	
		



