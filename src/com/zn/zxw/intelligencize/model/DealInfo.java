
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�ɷѼ�¼���
	*/
    public class DealInfo implements Serializable
    {
        public DealInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _dealId;//�߼����
		/**
		*�ɷ���
		*/
		private String   _userId;//�ɷ���
		/**
		*�ɷ�ʱ��
		*/
		private String   _date;//�ɷ�ʱ��
		/**
		*������
		*/
		private String   _payId;//������
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		private  DealTypeInfo  _dealTypeInfo;
		
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
		public String getDealId()
		{
		
			 return _dealId; 
		}
		/**
		*�߼����
		*/
		public void  setDealId (String  DealId )
		{
			_dealId = DealId ;
		}
		
		
		/**
		*�ɷ���
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*�ɷ���
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*�ɷ�ʱ��
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*�ɷ�ʱ��
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*������
		*/
		public String getPayId()
		{
		
			 return _payId; 
		}
		/**
		*������
		*/
		public void  setPayId (String  PayId )
		{
			_payId = PayId ;
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
		
		public DealTypeInfo  getDealTypeInfo()
		{
		return _dealTypeInfo;
		}
		
		public void  setDealTypeInfo(DealTypeInfo  DealTypeInfo)
		{
		 _dealTypeInfo =DealTypeInfo;
		
		}
		
		
				//list FK
  }
 
	
		



