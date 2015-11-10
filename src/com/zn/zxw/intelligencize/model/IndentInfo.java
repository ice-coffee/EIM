
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:订单
	*/
    public class IndentInfo implements Serializable
    {
        public IndentInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _indentId;//逻辑编号
		/**
		*商家编号
		*/
		private String   _shopId;//商家编号
		/**
		*下单人
		*/
		private String   _userId;//下单人
		/**
		*地址
		*/
		private String   _userAddress;//地址
		/**
		*电话
		*/
		private String   _tel;//电话
		/**
		*用户姓名
		*/
		private String   _userName;//用户姓名
		/**
		*下单时间
		*/
		private String   _indentDate;//下单时间
		/**
		*评价得分
		*/
		private String   _scoreId;//评价得分
		/**
		*取货时间
		*/
		private String   _getDate;//取货时间
		/**
		*j交易完成时间
		*/
		private String   _overDate;//j交易完成时间
		/**
		*状态
		*/
		private String   _state;//状态
		/**
		*是否付款(0=false，1=true)
		*/
		private int   _whetherPayment;//是否付款(0=false，1=true)
		/**
		*是否完成交易(0=false，1=true)
		*/
		private int   _whetherCompleteTransaction;//是否完成交易(0=false，1=true)
		/**
		*是否退货(0=false，1=true)
		*/
		private int   _whetherReturn;//是否退货(0=false，1=true)
		/**
		*备注
		*/
		private String   _remark;//备注
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  ShopInformationInfo  _shopInformationInfo;
		private  OfUser  _ofUser;
		
		//list FK
 private List<IndentListInfo> _indentListInfos;
		
		
		
		
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
		public String getIndentId()
		{
		
			 return _indentId; 
		}
		/**
		*逻辑编号
		*/
		public void  setIndentId (String  IndentId )
		{
			_indentId = IndentId ;
		}
		
		
		/**
		*商家编号
		*/
		public String getShopId()
		{
		
			 return _shopId; 
		}
		/**
		*商家编号
		*/
		public void  setShopId (String  ShopId )
		{
			_shopId = ShopId ;
		}
		
		
		/**
		*下单人
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*下单人
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*地址
		*/
		public String getUserAddress()
		{
		
			 return _userAddress; 
		}
		/**
		*地址
		*/
		public void  setUserAddress (String  UserAddress )
		{
			_userAddress = UserAddress ;
		}
		
		
		/**
		*电话
		*/
		public String getTel()
		{
		
			 return _tel; 
		}
		/**
		*电话
		*/
		public void  setTel (String  Tel )
		{
			_tel = Tel ;
		}
		
		
		/**
		*用户姓名
		*/
		public String getUserName()
		{
		
			 return _userName; 
		}
		/**
		*用户姓名
		*/
		public void  setUserName (String  UserName )
		{
			_userName = UserName ;
		}
		
		
		/**
		*下单时间
		*/
		public String getIndentDate()
		{
		
			 return _indentDate; 
		}
		/**
		*下单时间
		*/
		public void  setIndentDate (String  IndentDate )
		{
			_indentDate = IndentDate ;
		}
		
		
		/**
		*评价得分
		*/
		public String getScoreId()
		{
		
			 return _scoreId; 
		}
		/**
		*评价得分
		*/
		public void  setScoreId (String  ScoreId )
		{
			_scoreId = ScoreId ;
		}
		
		
		/**
		*取货时间
		*/
		public String getGetDate()
		{
		
			 return _getDate; 
		}
		/**
		*取货时间
		*/
		public void  setGetDate (String  GetDate )
		{
			_getDate = GetDate ;
		}
		
		
		/**
		*j交易完成时间
		*/
		public String getOverDate()
		{
		
			 return _overDate; 
		}
		/**
		*j交易完成时间
		*/
		public void  setOverDate (String  OverDate )
		{
			_overDate = OverDate ;
		}
		
		
		/**
		*状态
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*状态
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*是否付款(0=false，1=true)
		*/
		public int getWhetherPayment()
		{
		
			 return _whetherPayment; 
		}
		/**
		*是否付款(0=false，1=true)
		*/
		public void  setWhetherPayment (int  WhetherPayment )
		{
			_whetherPayment = WhetherPayment ;
		}
		
		
		/**
		*是否完成交易(0=false，1=true)
		*/
		public int getWhetherCompleteTransaction()
		{
		
			 return _whetherCompleteTransaction; 
		}
		/**
		*是否完成交易(0=false，1=true)
		*/
		public void  setWhetherCompleteTransaction (int  WhetherCompleteTransaction )
		{
			_whetherCompleteTransaction = WhetherCompleteTransaction ;
		}
		
		
		/**
		*是否退货(0=false，1=true)
		*/
		public int getWhetherReturn()
		{
		
			 return _whetherReturn; 
		}
		/**
		*是否退货(0=false，1=true)
		*/
		public void  setWhetherReturn (int  WhetherReturn )
		{
			_whetherReturn = WhetherReturn ;
		}
		
		
		/**
		*备注
		*/
		public String getRemark()
		{
		
			 return _remark; 
		}
		/**
		*备注
		*/
		public void  setRemark (String  Remark )
		{
			_remark = Remark ;
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
		
	
		
		
		
		public ShopInformationInfo  getShopInformationInfo()
		{
		return _shopInformationInfo;
		}
		
		public void  setShopInformationInfo(ShopInformationInfo  ShopInformationInfo)
		{
		 _shopInformationInfo =ShopInformationInfo;
		
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
     		public List< IndentListInfo>  getIndentListInfos()
		{
		return _indentListInfos;
		}
		
		public void  setIndentListInfos(List<IndentListInfo>  IndentListInfos)
		{
		 _indentListInfos =IndentListInfos;
		
		}
    }
 
	
		



