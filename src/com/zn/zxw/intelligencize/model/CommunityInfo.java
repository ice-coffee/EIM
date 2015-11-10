
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:社区信息
	*/
    public class CommunityInfo implements Serializable
    {
        public CommunityInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _community;//逻辑编号
		/**
		*名称
		*/
		private String   _name;//名称
		/**
		*城市区域
		*/
		private int   _cityId;//城市区域
		/**
		*居委会编号
		*/
		private String   _nCId;//居委会编号
		/**
		*物管编号
		*/
		private String   _pMCId;//物管编号
		/**
		*坐标
		*/
		private String   _coord;//坐标
		/**
		*预留字段
		*/
		private String   _field;//预留字段
		private  CityInfo  _cityInfo;
		private  NeighborhoodCommitteeInfo  _neighborhoodCommitteeInfo;
		private  PropertyManagementCompanyInfo  _propertyManagementCompanyInfo;
		
		//list FK
 private List<ComplaintInfo> _complaintInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
 private List<UserCommunityInfo> _userCommunityInfos;
		
		
		
		
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
		public String getCommunity()
		{
		
			 return _community; 
		}
		/**
		*逻辑编号
		*/
		public void  setCommunity (String  Community )
		{
			_community = Community ;
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
		*居委会编号
		*/
		public String getNCId()
		{
		
			 return _nCId; 
		}
		/**
		*居委会编号
		*/
		public void  setNCId (String  NCId )
		{
			_nCId = NCId ;
		}
		
		
		/**
		*物管编号
		*/
		public String getPMCId()
		{
		
			 return _pMCId; 
		}
		/**
		*物管编号
		*/
		public void  setPMCId (String  PMCId )
		{
			_pMCId = PMCId ;
		}
		
		
		/**
		*坐标
		*/
		public String getCoord()
		{
		
			 return _coord; 
		}
		/**
		*坐标
		*/
		public void  setCoord (String  Coord )
		{
			_coord = Coord ;
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
		
	
		
		
		
		public CityInfo  getCityInfo()
		{
		return _cityInfo;
		}
		
		public void  setCityInfo(CityInfo  CityInfo)
		{
		 _cityInfo =CityInfo;
		
		}
		
		public NeighborhoodCommitteeInfo  getNeighborhoodCommitteeInfo()
		{
		return _neighborhoodCommitteeInfo;
		}
		
		public void  setNeighborhoodCommitteeInfo(NeighborhoodCommitteeInfo  NeighborhoodCommitteeInfo)
		{
		 _neighborhoodCommitteeInfo =NeighborhoodCommitteeInfo;
		
		}
		
		public PropertyManagementCompanyInfo  getPropertyManagementCompanyInfo()
		{
		return _propertyManagementCompanyInfo;
		}
		
		public void  setPropertyManagementCompanyInfo(PropertyManagementCompanyInfo  PropertyManagementCompanyInfo)
		{
		 _propertyManagementCompanyInfo =PropertyManagementCompanyInfo;
		
		}
		
		
				//list FK
     		public List< ComplaintInfo>  getComplaintInfos()
		{
		return _complaintInfos;
		}
		
		public void  setComplaintInfos(List<ComplaintInfo>  ComplaintInfos)
		{
		 _complaintInfos =ComplaintInfos;
		
		}
       		public List< ShopInformationInfo>  getShopInformationInfos()
		{
		return _shopInformationInfos;
		}
		
		public void  setShopInformationInfos(List<ShopInformationInfo>  ShopInformationInfos)
		{
		 _shopInformationInfos =ShopInformationInfos;
		
		}
       		public List< UserCommunityInfo>  getUserCommunityInfos()
		{
		return _userCommunityInfos;
		}
		
		public void  setUserCommunityInfos(List<UserCommunityInfo>  UserCommunityInfos)
		{
		 _userCommunityInfos =UserCommunityInfos;
		
		}
    }
 
	
		



