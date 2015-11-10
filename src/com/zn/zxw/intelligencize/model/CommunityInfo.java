
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:������Ϣ
	*/
    public class CommunityInfo implements Serializable
    {
        public CommunityInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _community;//�߼����
		/**
		*����
		*/
		private String   _name;//����
		/**
		*��������
		*/
		private int   _cityId;//��������
		/**
		*��ί����
		*/
		private String   _nCId;//��ί����
		/**
		*��ܱ��
		*/
		private String   _pMCId;//��ܱ��
		/**
		*����
		*/
		private String   _coord;//����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  CityInfo  _cityInfo;
		private  NeighborhoodCommitteeInfo  _neighborhoodCommitteeInfo;
		private  PropertyManagementCompanyInfo  _propertyManagementCompanyInfo;
		
		//list FK
 private List<ComplaintInfo> _complaintInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
 private List<UserCommunityInfo> _userCommunityInfos;
		
		
		
		
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
		*�߼����
		*/
		public String getCommunity()
		{
		
			 return _community; 
		}
		/**
		*�߼����
		*/
		public void  setCommunity (String  Community )
		{
			_community = Community ;
		}
		
		
		/**
		*����
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*����
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*��������
		*/
		public int getCityId()
		{
		
			 return _cityId; 
		}
		/**
		*��������
		*/
		public void  setCityId (int  CityId )
		{
			_cityId = CityId ;
		}
		
		
		/**
		*��ί����
		*/
		public String getNCId()
		{
		
			 return _nCId; 
		}
		/**
		*��ί����
		*/
		public void  setNCId (String  NCId )
		{
			_nCId = NCId ;
		}
		
		
		/**
		*��ܱ��
		*/
		public String getPMCId()
		{
		
			 return _pMCId; 
		}
		/**
		*��ܱ��
		*/
		public void  setPMCId (String  PMCId )
		{
			_pMCId = PMCId ;
		}
		
		
		/**
		*����
		*/
		public String getCoord()
		{
		
			 return _coord; 
		}
		/**
		*����
		*/
		public void  setCoord (String  Coord )
		{
			_coord = Coord ;
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
 
	
		



