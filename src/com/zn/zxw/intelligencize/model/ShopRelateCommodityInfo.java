
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�����̼�����Щ��Ʒ
	*/
    public class ShopRelateCommodityInfo implements Serializable
    {
        public ShopRelateCommodityInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�̼ұ��
		*/
		private String   _shopInformationId;//�̼ұ��
		/**
		*��Ʒ���
		*/
		private String   _commoditId;//��Ʒ���
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		
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
		*�̼ұ��
		*/
		public String getShopInformationId()
		{
		
			 return _shopInformationId; 
		}
		/**
		*�̼ұ��
		*/
		public void  setShopInformationId (String  ShopInformationId )
		{
			_shopInformationId = ShopInformationId ;
		}
		
		
		/**
		*��Ʒ���
		*/
		public String getCommoditId()
		{
		
			 return _commoditId; 
		}
		/**
		*��Ʒ���
		*/
		public void  setCommoditId (String  CommoditId )
		{
			_commoditId = CommoditId ;
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
		
	
		
		
		
		
				//list FK
  }
 
	
		



