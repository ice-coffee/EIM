
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:关联商家有哪些商品
	*/
    public class ShopRelateCommodityInfo implements Serializable
    {
        public ShopRelateCommodityInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*商家编号
		*/
		private String   _shopInformationId;//商家编号
		/**
		*商品编号
		*/
		private String   _commoditId;//商品编号
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		
		//list FK
		
		
		
		
		/**
		*编号
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*编号
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*商家编号
		*/
		public String getShopInformationId()
		{
		
			 return _shopInformationId; 
		}
		/**
		*商家编号
		*/
		public void  setShopInformationId (String  ShopInformationId )
		{
			_shopInformationId = ShopInformationId ;
		}
		
		
		/**
		*商品编号
		*/
		public String getCommoditId()
		{
		
			 return _commoditId; 
		}
		/**
		*商品编号
		*/
		public void  setCommoditId (String  CommoditId )
		{
			_commoditId = CommoditId ;
		}
		
		
		/**
		*预留字段
		*/
		public String getField()
		{
		
			 return _field; 
		}
		/**
		*预留字段
		*/
		public void  setField (String  Field )
		{
			_field = Field ;
		}
		
	
		
		
		
		
				//list FK
  }
 
	
		



