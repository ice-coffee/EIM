
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼�̼�����Щ�ۿۺͻ
	*/
    public class ShopDiscountInfo implements Serializable
    {
        public ShopDiscountInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _shopDiscountId;//�߼����
		/**
		*�̼ұ��
		*/
		private String   _shopInformationId;//�̼ұ��
		/**
		*���ʽ
		*/
		private String   _typeId;//���ʽ
		/**
		*��ʼʱ��
		*/
		private String   _scoreListId;//��ʼʱ��
		/**
		*����ʱ��
		*/
		private int   _size;//����ʱ��
		/**
		*�������
		*/
		private int   _accumulativelntegra;//�������
		/**
		*����ȼ�
		*/
		private String   _level;//����ȼ�
		/**
		*�ͼƬ
		*/
		private String   _pictureListId;//�ͼƬ
		/**
		*�����
		*/
		private String   _desclibe;//�����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ShopInformationInfo  _shopInformationInfo;
		
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
		public String getShopDiscountId()
		{
		
			 return _shopDiscountId; 
		}
		/**
		*�߼����
		*/
		public void  setShopDiscountId (String  ShopDiscountId )
		{
			_shopDiscountId = ShopDiscountId ;
		}
		
		
		/**
		*�̼ұ��
		*/
		public String getShopInformationId()
		{
		
			 return _shopInformationId; 
		}
		/**
		*�̼ұ��
		*/
		public void  setShopInformationId (String  ShopInformationId )
		{
			_shopInformationId = ShopInformationId ;
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
		public String getScoreListId()
		{
		
			 return _scoreListId; 
		}
		/**
		*��ʼʱ��
		*/
		public void  setScoreListId (String  ScoreListId )
		{
			_scoreListId = ScoreListId ;
		}
		
		
		/**
		*����ʱ��
		*/
		public int getSize()
		{
		
			 return _size; 
		}
		/**
		*����ʱ��
		*/
		public void  setSize (int  Size )
		{
			_size = Size ;
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
		*�����
		*/
		public String getDesclibe()
		{
		
			 return _desclibe; 
		}
		/**
		*�����
		*/
		public void  setDesclibe (String  Desclibe )
		{
			_desclibe = Desclibe ;
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
		
		
				//list FK
  }
 
	
		



