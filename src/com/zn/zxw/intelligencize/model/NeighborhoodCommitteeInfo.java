
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��ί��
	*/
    public class NeighborhoodCommitteeInfo implements Serializable
    {
        public NeighborhoodCommitteeInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*����
		*/
		private String   _name;//����
		/**
		*��������
		*/
		private int   _cityId;//��������
		/**
		*������
		*/
		private String   _custodianId;//������
		/**
		*�绰
		*/
		private String   _tel;//�绰
		/**
		*��ַ
		*/
		private String   _address;//��ַ
		/**
		*����
		*/
		private String   _scoreListId;//����
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		private  CityInfo  _cityInfo;
		
		//list FK
 private List<CommunityInfo> _communityInfos;
		
		
		
		
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
		*������
		*/
		public String getCustodianId()
		{
		
			 return _custodianId; 
		}
		/**
		*������
		*/
		public void  setCustodianId (String  CustodianId )
		{
			_custodianId = CustodianId ;
		}
		
		
		/**
		*�绰
		*/
		public String getTel()
		{
		
			 return _tel; 
		}
		/**
		*�绰
		*/
		public void  setTel (String  Tel )
		{
			_tel = Tel ;
		}
		
		
		/**
		*��ַ
		*/
		public String getAddress()
		{
		
			 return _address; 
		}
		/**
		*��ַ
		*/
		public void  setAddress (String  Address )
		{
			_address = Address ;
		}
		
		
		/**
		*����
		*/
		public String getScoreListId()
		{
		
			 return _scoreListId; 
		}
		/**
		*����
		*/
		public void  setScoreListId (String  ScoreListId )
		{
			_scoreListId = ScoreListId ;
		}
		
		
		/**
		*����
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*����
		*/
		public void  setDescribe (String  Describe )
		{
			_describe = Describe ;
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
 
	
		



