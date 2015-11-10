
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*±¸×¢:½É·Ñ¼ÇÂ¼±àºÅ
	*/
    public class DealInfo implements Serializable
    {
        public DealInfo()
        { }
		
		
		/**
		*±àºÅ
		*/
		private String   _id;//±àºÅ
		/**
		*Âß¼­±àºÅ
		*/
		private String   _dealId;//Âß¼­±àºÅ
		/**
		*½É·ÑÈË
		*/
		private String   _userId;//½É·ÑÈË
		/**
		*½É·ÑÊ±¼ä
		*/
		private String   _date;//½É·ÑÊ±¼ä
		/**
		*¸¶¿î±àºÅ
		*/
		private String   _payId;//¸¶¿î±àºÅ
		/**
		*Ô¤Áô×Ö¶Î
		*/
		private String   _field;//Ô¤Áô×Ö¶Î
		private  OfUser  _ofUser;
		private  DealTypeInfo  _dealTypeInfo;
		
		//list FK
		
		
		
		
		/**
		*±àºÅ
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*±àºÅ
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*Âß¼­±àºÅ
		*/
		public String getDealId()
		{
		
			 return _dealId; 
		}
		/**
		*Âß¼­±àºÅ
		*/
		public void  setDealId (String  DealId )
		{
			_dealId = DealId ;
		}
		
		
		/**
		*½É·ÑÈË
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*½É·ÑÈË
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*½É·ÑÊ±¼ä
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*½É·ÑÊ±¼ä
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*¸¶¿î±àºÅ
		*/
		public String getPayId()
		{
		
			 return _payId; 
		}
		/**
		*¸¶¿î±àºÅ
		*/
		public void  setPayId (String  PayId )
		{
			_payId = PayId ;
		}
		
		
		/**
		*Ô¤Áô×Ö¶Î
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*Ô¤Áô×Ö¶Î
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
 
	
		



