
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:�̼ҵĻ�����Ϣ
	*/
    public class ShopInformationInfo implements Serializable
    {
        public ShopInformationInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _shopInformationId;//�߼����
		/**
		*����
		*/
		private String   _name;//����
		/**
		*��ַ
		*/
		private String   _address;//��ַ
		/**
		*�÷�
		*/
		private String   _scoreListId;//�÷�
		/**
		*�����С
		*/
		private int   _size;//�����С
		/**
		*������
		*/
		private String   _ownerId;//������
		/**
		*��ϵ�绰
		*/
		private String   _tel;//��ϵ�绰
		/**
		*����ͼƬ
		*/
		private String   _shopPicId;//����ͼƬ
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*������������
		*/
		private String   _area;//������������
		/**
		*��Ӫ����
		*/
		private String   _type;//��Ӫ����
		/**
		*���״̬
		*/
		private String   _acceptState;//���״̬
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  TypeMenuInfo  _typeMenuInfo;
		private  CommunityInfo  _communityInfo;
		private  ShopAcceptInfo  _shopAcceptInfo;
		
		//list FK
 private List<CommodityDiscountInfo> _commodityDiscountInfos;
 private List<IndentInfo> _indentInfos;
 private List<ShopDiscountInfo> _shopDiscountInfos;
		
		
		
		
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
		public String getShopInformationId()
		{
		
			 return _shopInformationId; 
		}
		/**
		*�߼����
		*/
		public void  setShopInformationId (String  ShopInformationId )
		{
			_shopInformationId = ShopInformationId ;
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
		*�÷�
		*/
		public String getScoreListId()
		{
		
			 return _scoreListId; 
		}
		/**
		*�÷�
		*/
		public void  setScoreListId (String  ScoreListId )
		{
			_scoreListId = ScoreListId ;
		}
		
		
		/**
		*�����С
		*/
		public int getSize()
		{
		
			 return _size; 
		}
		/**
		*�����С
		*/
		public void  setSize (int  Size )
		{
			_size = Size ;
		}
		
		
		/**
		*������
		*/
		public String getOwnerId()
		{
		
			 return _ownerId; 
		}
		/**
		*������
		*/
		public void  setOwnerId (String  OwnerId )
		{
			_ownerId = OwnerId ;
		}
		
		
		/**
		*��ϵ�绰
		*/
		public String getTel()
		{
		
			 return _tel; 
		}
		/**
		*��ϵ�绰
		*/
		public void  setTel (String  Tel )
		{
			_tel = Tel ;
		}
		
		
		/**
		*����ͼƬ
		*/
		public String getShopPicId()
		{
		
			 return _shopPicId; 
		}
		/**
		*����ͼƬ
		*/
		public void  setShopPicId (String  ShopPicId )
		{
			_shopPicId = ShopPicId ;
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
		*������������
		*/
		public String getArea()
		{
		
			 return _area; 
		}
		/**
		*������������
		*/
		public void  setArea (String  Area )
		{
			_area = Area ;
		}
		
		
		/**
		*��Ӫ����
		*/
		public String getType()
		{
		
			 return _type; 
		}
		/**
		*��Ӫ����
		*/
		public void  setType (String  Type )
		{
			_type = Type ;
		}
		
		
		/**
		*���״̬
		*/
		public String getAcceptState()
		{
		
			 return _acceptState; 
		}
		/**
		*���״̬
		*/
		public void  setAcceptState (String  AcceptState )
		{
			_acceptState = AcceptState ;
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
 
	
		



