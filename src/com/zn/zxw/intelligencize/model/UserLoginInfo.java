
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�û���¼��¼��
	*/
    public class UserLoginInfo implements Serializable
    {
        public UserLoginInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _userLoginId;//�߼����
		/**
		*��¼�û�
		*/
		private String   _userId;//��¼�û�
		/**
		*��¼ʱ��
		*/
		private String   _date;//��¼ʱ��
		/**
		*��¼ip
		*/
		private String   _iP;//��¼ip
		/**
		*����
		*/
		private String   _describe;//����
		private  OfUser  _ofUser;
		
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
		*�߼����
		*/
		public String getUserLoginId()
		{
		
			 return _userLoginId; 
		}
		/**
		*�߼����
		*/
		public void  setUserLoginId (String  UserLoginId )
		{
			_userLoginId = UserLoginId ;
		}
		
		
		/**
		*��¼�û�
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*��¼�û�
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*��¼ʱ��
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*��¼ʱ��
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*��¼ip
		*/
		public String getIP()
		{
		
			 return _iP; 
		}
		/**
		*��¼ip
		*/
		public void  setIP (String  IP )
		{
			_iP = IP ;
		}
		
		
		/**
		*����
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*����
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
		}
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		
				//list FK
  }
 
	
		



