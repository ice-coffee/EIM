
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:���б�
	*/
    public class CityInfo implements Serializable
    {
        public CityInfo()
        { }
		
		
		/**
		*���
		*/
		private int   _id;//���
		/**
		*����
		*/
		private String   _name;//����
		/**
		*����
		*/
		private int   _parentId;//����
		/**
		*����
		*/
		private String   _areaCode;//����
		/**
		*��������
		*/
		private int   _level;//��������
		/**
		*�������
		*/
		private String   _type;//�������
		/**
		*����
		*/
		private int   _order;//����
		
		//list FK
 private List<CommunityInfo> _communityInfos;
 private List<NeighborhoodCommitteeInfo> _neighborhoodCommitteeInfos;
 private List<PropertyManagementCompanyInfo> _propertyManagementCompanyInfos;
		
		
		
		
		/**
		*���
		*/
		public int getId()
		{
		
			 return _id; 
		}
		/**
		*���
		*/
		public void  setId (int  Id )
		{
			_id = Id ;
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
		*����
		*/
		public int getParentId()
		{
		
			 return _parentId; 
		}
		/**
		*����
		*/
		public void  setParentId (int  ParentId )
		{
			_parentId = ParentId ;
		}
		
		
		/**
		*����
		*/
		public String getAreaCode()
		{
		
			 return _areaCode; 
		}
		/**
		*����
		*/
		public void  setAreaCode (String  AreaCode )
		{
			_areaCode = AreaCode ;
		}
		
		
		/**
		*��������
		*/
		public int getLevel()
		{
		
			 return _level; 
		}
		/**
		*��������
		*/
		public void  setLevel (int  Level )
		{
			_level = Level ;
		}
		
		
		/**
		*�������
		*/
		public String getType()
		{
		
			 return _type; 
		}
		/**
		*�������
		*/
		public void  setType (String  Type )
		{
			_type = Type ;
		}
		
		
		/**
		*����
		*/
		public int getOrder()
		{
		
			 return _order; 
		}
		/**
		*����
		*/
		public void  setOrder (int  Order )
		{
			_order = Order ;
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
       		public List< NeighborhoodCommitteeInfo>  getNeighborhoodCommitteeInfos()
		{
		return _neighborhoodCommitteeInfos;
		}
		
		public void  setNeighborhoodCommitteeInfos(List<NeighborhoodCommitteeInfo>  NeighborhoodCommitteeInfos)
		{
		 _neighborhoodCommitteeInfos =NeighborhoodCommitteeInfos;
		
		}
       		public List< PropertyManagementCompanyInfo>  getPropertyManagementCompanyInfos()
		{
		return _propertyManagementCompanyInfos;
		}
		
		public void  setPropertyManagementCompanyInfos(List<PropertyManagementCompanyInfo>  PropertyManagementCompanyInfos)
		{
		 _propertyManagementCompanyInfos =PropertyManagementCompanyInfos;
		
		}
    }
 
	
		



