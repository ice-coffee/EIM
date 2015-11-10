
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:类似水费，电费，燃气费
	*/
    public class DealTypeInfo implements Serializable
    {
        public DealTypeInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _dealTypeId;//逻辑编号
		/**
		*缴费类型
		*/
		private String   _name;//缴费类型
		/**
		*计量单位
		*/
		private String   _unit;//计量单位
		/**
		*单价
		*/
		private Double   _price;//单价
		/**
		*用量
		*/
		private Double   _dosage;//用量
		/**
		*金额
		*/
		private Double   _money;//金额
		/**
		*缴费月度
		*/
		private String   _month;//缴费月度
		/**
		*每月什么时候记录用量
		*/
		private String   _operateDate;//每月什么时候记录用量
		/**
		*是否已付款
		*/
		private int   _ifPay;//是否已付款
		/**
		*滞纳金
		*/
		private Double   _overdueFine;//滞纳金
		/**
		*记录操作人
		*/
		private String   _userId;//记录操作人
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  OfUser  _ofUser;
		
		//list FK
 private List<DealInfo> _dealInfos;
		
		
		
		
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
		public String getDealTypeId()
		{
		
			 return _dealTypeId; 
		}
		/**
		*逻辑编号
		*/
		public void  setDealTypeId (String  DealTypeId )
		{
			_dealTypeId = DealTypeId ;
		}
		
		
		/**
		*缴费类型
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*缴费类型
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*计量单位
		*/
		public String getUnit()
		{
		
			 return _unit; 
		}
		/**
		*计量单位
		*/
		public void  setUnit (String  Unit )
		{
			_unit = Unit ;
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
		*用量
		*/
		public Double getDosage()
		{
		
			 return _dosage; 
		}
		/**
		*用量
		*/
		public void  setDosage (Double  Dosage )
		{
			_dosage = Dosage ;
		}
		
		
		/**
		*金额
		*/
		public Double getMoney()
		{
		
			 return _money; 
		}
		/**
		*金额
		*/
		public void  setMoney (Double  Money )
		{
			_money = Money ;
		}
		
		
		/**
		*缴费月度
		*/
		public String getMonth()
		{
		
			 return _month; 
		}
		/**
		*缴费月度
		*/
		public void  setMonth (String  Month )
		{
			_month = Month ;
		}
		
		
		/**
		*每月什么时候记录用量
		*/
		public String getOperateDate()
		{
		
			 return _operateDate; 
		}
		/**
		*每月什么时候记录用量
		*/
		public void  setOperateDate (String  OperateDate )
		{
			_operateDate = OperateDate ;
		}
		
		
		/**
		*是否已付款
		*/
		public int getIfPay()
		{
		
			 return _ifPay; 
		}
		/**
		*是否已付款
		*/
		public void  setIfPay (int  IfPay )
		{
			_ifPay = IfPay ;
		}
		
		
		/**
		*滞纳金
		*/
		public Double getOverdueFine()
		{
		
			 return _overdueFine; 
		}
		/**
		*滞纳金
		*/
		public void  setOverdueFine (Double  OverdueFine )
		{
			_overdueFine = OverdueFine ;
		}
		
		
		/**
		*记录操作人
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*记录操作人
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
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
		
	
		
		
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		
				//list FK
     		public List< DealInfo>  getDealInfos()
		{
		return _dealInfos;
		}
		
		public void  setDealInfos(List<DealInfo>  DealInfos)
		{
		 _dealInfos =DealInfos;
		
		}
    }
 
	
		



