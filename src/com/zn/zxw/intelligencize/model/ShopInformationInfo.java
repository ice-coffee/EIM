
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:商家的基本信息
	*/
    public class ShopInformationInfo implements Serializable
    {
        public ShopInformationInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _shopInformationId;//逻辑编号
		/**
		*名称
		*/
		private String   _name;//名称
		/**
		*地址
		*/
		private String   _address;//地址
		/**
		*得分
		*/
		private String   _scoreListId;//得分
		/**
		*店面大小
		*/
		private int   _size;//店面大小
		/**
		*所有人
		*/
		private String   _ownerId;//所有人
		/**
		*联系电话
		*/
		private String   _tel;//联系电话
		/**
		*店面图片
		*/
		private String   _shopPicId;//店面图片
		/**
		*评论
		*/
		private String   _describe;//评论
		/**
		*所在区域社区
		*/
		private String   _area;//所在区域社区
		/**
		*经营类型
		*/
		private String   _type;//经营类型
		/**
		*审核状态
		*/
		private String   _acceptState;//审核状态
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  TypeMenuInfo  _typeMenuInfo;
		private  CommunityInfo  _communityInfo;
		private  ShopAcceptInfo  _shopAcceptInfo;
		
		//list FK
 private List<CommodityDiscountInfo> _commodityDiscountInfos;
 private List<IndentInfo> _indentInfos;
 private List<ShopDiscountInfo> _shopDiscountInfos;
		
		
		
		
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
		public String getShopInformationId()
		{
		
			 return _shopInformationId; 
		}
		/**
		*逻辑编号
		*/
		public void  setShopInformationId (String  ShopInformationId )
		{
			_shopInformationId = ShopInformationId ;
		}
		
		
		/**
		*名称
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*名称
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*地址
		*/
		public String getAddress()
		{
		
			 return _address; 
		}
		/**
		*地址
		*/
		public void  setAddress (String  Address )
		{
			_address = Address ;
		}
		
		
		/**
		*得分
		*/
		public String getScoreListId()
		{
		
			 return _scoreListId; 
		}
		/**
		*得分
		*/
		public void  setScoreListId (String  ScoreListId )
		{
			_scoreListId = ScoreListId ;
		}
		
		
		/**
		*店面大小
		*/
		public int getSize()
		{
		
			 return _size; 
		}
		/**
		*店面大小
		*/
		public void  setSize (int  Size )
		{
			_size = Size ;
		}
		
		
		/**
		*所有人
		*/
		public String getOwnerId()
		{
		
			 return _ownerId; 
		}
		/**
		*所有人
		*/
		public void  setOwnerId (String  OwnerId )
		{
			_ownerId = OwnerId ;
		}
		
		
		/**
		*联系电话
		*/
		public String getTel()
		{
		
			 return _tel; 
		}
		/**
		*联系电话
		*/
		public void  setTel (String  Tel )
		{
			_tel = Tel ;
		}
		
		
		/**
		*店面图片
		*/
		public String getShopPicId()
		{
		
			 return _shopPicId; 
		}
		/**
		*店面图片
		*/
		public void  setShopPicId (String  ShopPicId )
		{
			_shopPicId = ShopPicId ;
		}
		
		
		/**
		*评论
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*评论
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
		}
		
		
		/**
		*所在区域社区
		*/
		public String getArea()
		{
		
			 return _area; 
		}
		/**
		*所在区域社区
		*/
		public void  setArea (String  Area )
		{
			_area = Area ;
		}
		
		
		/**
		*经营类型
		*/
		public String getType()
		{
		
			 return _type; 
		}
		/**
		*经营类型
		*/
		public void  setType (String  Type )
		{
			_type = Type ;
		}
		
		
		/**
		*审核状态
		*/
		public String getAcceptState()
		{
		
			 return _acceptState; 
		}
		/**
		*审核状态
		*/
		public void  setAcceptState (String  AcceptState )
		{
			_acceptState = AcceptState ;
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
		
	
		
		
		
		public TypeMenuInfo  getTypeMenuInfo()
		{
		return _typeMenuInfo;
		}
		
		public void  setTypeMenuInfo(TypeMenuInfo  TypeMenuInfo)
		{
		 _typeMenuInfo =TypeMenuInfo;
		
		}
		
		public CommunityInfo  getCommunityInfo()
		{
		return _communityInfo;
		}
		
		public void  setCommunityInfo(CommunityInfo  CommunityInfo)
		{
		 _communityInfo =CommunityInfo;
		
		}
		
		
		
		public ShopAcceptInfo  getShopAcceptInfo()
		{
		return _shopAcceptInfo;
		}
		
		public void  setShopAcceptInfo(ShopAcceptInfo  ShopAcceptInfo)
		{
		 _shopAcceptInfo =ShopAcceptInfo;
		
		}
		
		
				//list FK
     		public List< CommodityDiscountInfo>  getCommodityDiscountInfos()
		{
		return _commodityDiscountInfos;
		}
		
		public void  setCommodityDiscountInfos(List<CommodityDiscountInfo>  CommodityDiscountInfos)
		{
		 _commodityDiscountInfos =CommodityDiscountInfos;
		
		}
       		public List< IndentInfo>  getIndentInfos()
		{
		return _indentInfos;
		}
		
		public void  setIndentInfos(List<IndentInfo>  IndentInfos)
		{
		 _indentInfos =IndentInfos;
		
		}
       		public List< ShopDiscountInfo>  getShopDiscountInfos()
		{
		return _shopDiscountInfos;
		}
		
		public void  setShopDiscountInfos(List<ShopDiscountInfo>  ShopDiscountInfos)
		{
		 _shopDiscountInfos =ShopDiscountInfos;
		
		}
    }
 
	
		



