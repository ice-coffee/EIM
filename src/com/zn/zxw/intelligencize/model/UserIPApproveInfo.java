
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼IP�ڰ�����
	*/
    public class UserIPApproveInfo implements Serializable
    {
        public UserIPApproveInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*��֤�û�
		*/
		private String   _userId;//��֤�û�
		/**
		*��֤ʱ��
		*/
		private String   _date;//��֤ʱ��
		/**
		*��֤IP
		*/
		private String   _iP;//��֤IP
		/**
		*�ڰ�����(0=��������1=������)
		*/
		private int   _roll;//�ڰ�����(0=��������1=������)
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
		*��֤�û�
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*��֤�û�
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*��֤ʱ��
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*��֤ʱ��
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*��֤IP
		*/
		public String getIP()
		{
		
			 return _iP; 
		}
		/**
		*��֤IP
		*/
		public void  setIP (String  IP )
		{
			_iP = IP ;
		}
		
		
		/**
		*�ڰ�����(0=��������1=������)
		*/
		public int getRoll()
		{
		
			 return _roll; 
		}
		/**
		*�ڰ�����(0=��������1=������)
		*/
		public void  setRoll (int  Roll )
		{
			_roll = Roll ;
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
 
	
		



