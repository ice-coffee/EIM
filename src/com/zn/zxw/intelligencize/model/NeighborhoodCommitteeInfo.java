
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:居委会
	*/
    public class NeighborhoodCommitteeInfo implements Serializable
    {
        public NeighborhoodCommitteeInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*名称
		*/
		private String   _name;//名称
		/**
		*城市区域
		*/
		private int   _cityId;//城市区域
		/**
		*管理人
		*/
		private String   _custodianId;//管理人
		/**
		*电话
		*/
		private String   _tel;//电话
		/**
		*地址
		*/
		private String   _address;//地址
		/**
		*评分
		*/
		private String   _scoreListId;//评分
		/**
		*描述
		*/
		private String   _describe;//描述
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  OfUser  _ofUser;
		private  CityInfo  _cityInfo;
		
		//list FK
 private List<CommunityInfo> _communityInfos;
		
		
		
		
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
		*城市区域
		*/
		public int getCityId()
		{
		
			 return _cityId; 
		}
		/**
		*城市区域
		*/
		public void  setCityId (int  CityId )
		{
			_cityId = CityId ;
		}
		
		
		/**
		*管理人
		*/
		public String getCustodianId()
		{
		
			 return _custodianId; 
		}
		/**
		*管理人
		*/
		public void  setCustodianId (String  CustodianId )
		{
			_custodianId = CustodianId ;
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
		*评分
		*/
		public String getScoreListId()
		{
		
			 return _scoreListId; 
		}
		/**
		*评分
		*/
		public void  setScoreListId (String  ScoreListId )
		{
			_scoreListId = ScoreListId ;
		}
		
		
		/**
		*描述
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*描述
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
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
		
		public CityInfo  getCityInfo()
		{
		return _cityInfo;
		}
		
		public void  setCityInfo(CityInfo  CityInfo)
		{
		 _cityInfo =CityInfo;
		
		}
		
		
				//list FK
     		public List< CommunityInfo>  getCommunityInfos()
		{
		return _communityInfos;
		}
		
		public void  setCommunityInfos(List<CommunityInfo>  CommunityInfos)
		{
		 _communityInfos =CommunityInfos;
		
		}
    }
 
	
		



