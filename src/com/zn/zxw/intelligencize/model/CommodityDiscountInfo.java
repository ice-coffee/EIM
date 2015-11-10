
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼��Ʒ����Щ�ۿۺͻ
	*/
    public class CommodityDiscountInfo implements Serializable
    {
        public CommodityDiscountInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _cDId;//�߼����
		/**
		*��Ʒ���
		*/
		private String   _commodityInformationId;//��Ʒ���
		/**
		*�̼ұ��
		*/
		private String   _shopId;//�̼ұ��
		/**
		*���ʽ
		*/
		private String   _typeId;//���ʽ
		/**
		*��ʼʱ��
		*/
		private String   _startDate;//��ʼʱ��
		/**
		*����ʱ��
		*/
		private String   _endDate;//����ʱ��
		/**
		*�������
		*/
		private int   _accumulativelntegra;//�������
		/**
		*����ȼ�
		*/
		private String   _level;//����ȼ�
		/**
		*�ۿ�
		*/
		private Double   _discount;//�ۿ�
		/**
		*�ͼƬ
		*/
		private String   _pictureListId;//�ͼƬ
		/**
		*���۵÷�
		*/
		private String   _score;//���۵÷�
		/**
		*ԭ��
		*/
		private Double   _oldPrice;//ԭ��
		/**
		*���
		*/
		private Double   _newPrice;//���
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ShopInformationInfo  _shopInformationInfo;
		private  TypeLevelOneInfo  _typeLevelOneInfo;
		private  CommodityInformationInfo  _commodityInformationInfo;
		
		//list FK
		
		
		
		
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
		public String getCDId()
		{
		
			 return _cDId; 
		}
		/**
		*�߼����
		*/
		public void  setCDId (String  CDId )
		{
			_cDId = CDId ;
		}
		
		
		/**
		*��Ʒ���
		*/
		public String getCommodityInformationId()
		{
		
			 return _commodityInformationId; 
		}
		/**
		*��Ʒ���
		*/
		public void  setCommodityInformationId (String  CommodityInformationId )
		{
			_commodityInformationId = CommodityInformationId ;
		}
		
		
		/**
		*�̼ұ��
		*/
		public String getShopId()
		{
		
			 return _shopId; 
		}
		/**
		*�̼ұ��
		*/
		public void  setShopId (String  ShopId )
		{
			_shopId = ShopId ;
		}
		
		
		/**
		*���ʽ
		*/
		public String getTypeId()
		{
		
			 return _typeId; 
		}
		/**
		*���ʽ
		*/
		public void  setTypeId (String  TypeId )
		{
			_typeId = TypeId ;
		}
		
		
		/**
		*��ʼʱ��
		*/
		public String getStartDate()
		{
		
			 return _startDate; 
		}
		/**
		*��ʼʱ��
		*/
		public void  setStartDate (String  StartDate )
		{
			_startDate = StartDate ;
		}
		
		
		/**
		*����ʱ��
		*/
		public String getEndDate()
		{
		
			 return _endDate; 
		}
		/**
		*����ʱ��
		*/
		public void  setEndDate (String  EndDate )
		{
			_endDate = EndDate ;
		}
		
		
		/**
		*�������
		*/
		public int getAccumulativelntegra()
		{
		
			 return _accumulativelntegra; 
		}
		/**
		*�������
		*/
		public void  setAccumulativelntegra (int  Accumulativelntegra )
		{
			_accumulativelntegra = Accumulativelntegra ;
		}
		
		
		/**
		*����ȼ�
		*/
		public String getLevel()
		{
		
			 return _level; 
		}
		/**
		*����ȼ�
		*/
		public void  setLevel (String  Level )
		{
			_level = Level ;
		}
		
		
		/**
		*�ۿ�
		*/
		public Double getDiscount()
		{
		
			 return _discount; 
		}
		/**
		*�ۿ�
		*/
		public void  setDiscount (Double  Discount )
		{
			_discount = Discount ;
		}
		
		
		/**
		*�ͼƬ
		*/
		public String getPictureListId()
		{
		
			 return _pictureListId; 
		}
		/**
		*�ͼƬ
		*/
		public void  setPictureListId (String  PictureListId )
		{
			_pictureListId = PictureListId ;
		}
		
		
		/**
		*���۵÷�
		*/
		public String getScore()
		{
		
			 return _score; 
		}
		/**
		*���۵÷�
		*/
		public void  setScore (String  Score )
		{
			_score = Score ;
		}
		
		
		/**
		*ԭ��
		*/
		public Double getOldPrice()
		{
		
			 return _oldPrice; 
		}
		/**
		*ԭ��
		*/
		public void  setOldPrice (Double  OldPrice )
		{
			_oldPrice = OldPrice ;
		}
		
		
		/**
		*���
		*/
		public Double getNewPrice()
		{
		
			 return _newPrice; 
		}
		/**
		*���
		*/
		public void  setNewPrice (Double  NewPrice )
		{
			_newPrice = NewPrice ;
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
		
	
		
		
		
		public ShopInformationInfo  getShopInformationInfo()
		{
		return _shopInformationInfo;
		}
		
		public void  setShopInformationInfo(ShopInformationInfo  ShopInformationInfo)
		{
		 _shopInformationInfo =ShopInformationInfo;
		
		}
		
		public TypeLevelOneInfo  getTypeLevelOneInfo()
		{
		return _typeLevelOneInfo;
		}
		
		public void  setTypeLevelOneInfo(TypeLevelOneInfo  TypeLevelOneInfo)
		{
		 _typeLevelOneInfo =TypeLevelOneInfo;
		
		}
		
		public CommodityInformationInfo  getCommodityInformationInfo()
		{
		return _commodityInformationInfo;
		}
		
		public void  setCommodityInformationInfo(CommodityInformationInfo  CommodityInformationInfo)
		{
		 _commodityInformationInfo =CommodityInformationInfo;
		
		}
		
		
				//list FK
  }
 
	
		



