
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:物业公司信息
	*/
    public class PropertyManagementCompanyInfo implements Serializable
    {
        public PropertyManagementCompanyInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*公司名称
		*/
		private String   _name;//公司名称
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
		*公司地址
		*/
		private String   _address;//公司地址
		/**
		*评分
		*/
		private String   _scoreListId;//评分
		/**
		*描述
		*/
		private String   _describe;//描述
		/**
		*公司人员规模
		*/
		private int   _staffNumber;//公司人员规模
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
		*公司名称
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*公司名称
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
		*公司地址
		*/
		public String getAddress()
		{
		
			 return _address; 
		}
		/**
		*公司地址
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
		*公司人员规模
		*/
		public int getStaffNumber()
		{
		
			 return _staffNumber; 
		}
		/**
		*公司人员规模
		*/
		public void  setStaffNumber (int  StaffNumber )
		{
			_staffNumber = StaffNumber ;
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
 
	
		



