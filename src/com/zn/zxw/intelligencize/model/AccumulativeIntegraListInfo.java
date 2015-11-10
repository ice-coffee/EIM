
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:积分消费记录表
	*/
    public class AccumulativeIntegraListInfo implements Serializable
    {
        public AccumulativeIntegraListInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _accumulativeIntegraListId;//逻辑编号
		/**
		*消费数量
		*/
		private int   _cousumeQuantity;//消费数量
		/**
		*消费时间
		*/
		private String   _date;//消费时间
		/**
		*是否支出(1：true，0：false)
		*/
		private String   _expenditure;//是否支出(1：true，0：false)
		/**
		*消费对象表
		*/
		private String   _targetTable;//消费对象表
		/**
		*消费目标
		*/
		private String   _consumeTarget;//消费目标
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  CommodityInformationInfo  _commodityInformationInfo;
		
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
		public String getAccumulativeIntegraListId()
		{
		
			 return _accumulativeIntegraListId; 
		}
		/**
		*逻辑编号
		*/
		public void  setAccumulativeIntegraListId (String  AccumulativeIntegraListId )
		{
			_accumulativeIntegraListId = AccumulativeIntegraListId ;
		}
		
		
		/**
		*消费数量
		*/
		public int getCousumeQuantity()
		{
		
			 return _cousumeQuantity; 
		}
		/**
		*消费数量
		*/
		public void  setCousumeQuantity (int  CousumeQuantity )
		{
			_cousumeQuantity = CousumeQuantity ;
		}
		
		
		/**
		*消费时间
		*/
		public String getDate()
		{
		
			 return _date; 
		}
		/**
		*消费时间
		*/
		public void  setDate (String  Date )
		{
			_date = Date ;
		}
		
		
		/**
		*是否支出(1：true，0：false)
		*/
		public String getExpenditure()
		{
		
			 return _expenditure; 
		}
		/**
		*是否支出(1：true，0：false)
		*/
		public void  setExpenditure (String  Expenditure )
		{
			_expenditure = Expenditure ;
		}
		
		
		/**
		*消费对象表
		*/
		public String getTargetTable()
		{
		
			 return _targetTable; 
		}
		/**
		*消费对象表
		*/
		public void  setTargetTable (String  TargetTable )
		{
			_targetTable = TargetTable ;
		}
		
		
		/**
		*消费目标
		*/
		public String getConsumeTarget()
		{
		
			 return _consumeTarget; 
		}
		/**
		*消费目标
		*/
		public void  setConsumeTarget (String  ConsumeTarget )
		{
			_consumeTarget = ConsumeTarget ;
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
		
		
				//list FK
  }
 
	
		



