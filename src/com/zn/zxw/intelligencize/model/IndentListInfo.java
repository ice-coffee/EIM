
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:记录用户选择商品的清单
	*/
    public class IndentListInfo implements Serializable
    {
        public IndentListInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _indentListId;//逻辑编号
		/**
		*订单编号
		*/
		private String   _indentId;//订单编号
		/**
		*商品编号
		*/
		private String   _cIId;//商品编号
		/**
		*折扣
		*/
		private Double   _discount;//折扣
		/**
		*商品名称
		*/
		private String   _commodityName;//商品名称
		/**
		*商品数量
		*/
		private int   _num;//商品数量
		/**
		*单价
		*/
		private Double   _price;//单价
		/**
		*积分
		*/
		private int   _accumulativelntegra;//积分
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  CommodityInformationInfo  _commodityInformationInfo;
		private  IndentInfo  _indentInfo;
		
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
		*逻辑编号
		*/
		public String getIndentListId()
		{
		
			 return _indentListId; 
		}
		/**
		*逻辑编号
		*/
		public void  setIndentListId (String  IndentListId )
		{
			_indentListId = IndentListId ;
		}
		
		
		/**
		*订单编号
		*/
		public String getIndentId()
		{
		
			 return _indentId; 
		}
		/**
		*订单编号
		*/
		public void  setIndentId (String  IndentId )
		{
			_indentId = IndentId ;
		}
		
		
		/**
		*商品编号
		*/
		public String getCIId()
		{
		
			 return _cIId; 
		}
		/**
		*商品编号
		*/
		public void  setCIId (String  CIId )
		{
			_cIId = CIId ;
		}
		
		
		/**
		*折扣
		*/
		public Double getDiscount()
		{
		
			 return _discount; 
		}
		/**
		*折扣
		*/
		public void  setDiscount (Double  Discount )
		{
			_discount = Discount ;
		}
		
		
		/**
		*商品名称
		*/
		public String getCommodityName()
		{
		
			 return _commodityName; 
		}
		/**
		*商品名称
		*/
		public void  setCommodityName (String  CommodityName )
		{
			_commodityName = CommodityName ;
		}
		
		
		/**
		*商品数量
		*/
		public int getNum()
		{
		
			 return _num; 
		}
		/**
		*商品数量
		*/
		public void  setNum (int  Num )
		{
			_num = Num ;
		}
		
		
		/**
		*单价
		*/
		public Double getPrice()
		{
		
			 return _price; 
		}
		/**
		*单价
		*/
		public void  setPrice (Double  Price )
		{
			_price = Price ;
		}
		
		
		/**
		*积分
		*/
		public int getAccumulativelntegra()
		{
		
			 return _accumulativelntegra; 
		}
		/**
		*积分
		*/
		public void  setAccumulativelntegra (int  Accumulativelntegra )
		{
			_accumulativelntegra = Accumulativelntegra ;
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
		
	
		
		
		
		public CommodityInformationInfo  getCommodityInformationInfo()
		{
		return _commodityInformationInfo;
		}
		
		public void  setCommodityInformationInfo(CommodityInformationInfo  CommodityInformationInfo)
		{
		 _commodityInformationInfo =CommodityInformationInfo;
		
		}
		
		public IndentInfo  getIndentInfo()
		{
		return _indentInfo;
		}
		
		public void  setIndentInfo(IndentInfo  IndentInfo)
		{
		 _indentInfo =IndentInfo;
		
		}
		
		
				//list FK
  }
 
	
		



