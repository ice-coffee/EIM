
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��¼�û�ѡ����Ʒ���嵥
	*/
    public class IndentListInfo implements Serializable
    {
        public IndentListInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _indentListId;//�߼����
		/**
		*�������
		*/
		private String   _indentId;//�������
		/**
		*��Ʒ���
		*/
		private String   _cIId;//��Ʒ���
		/**
		*�ۿ�
		*/
		private Double   _discount;//�ۿ�
		/**
		*��Ʒ����
		*/
		private String   _commodityName;//��Ʒ����
		/**
		*��Ʒ����
		*/
		private int   _num;//��Ʒ����
		/**
		*����
		*/
		private Double   _price;//����
		/**
		*����
		*/
		private int   _accumulativelntegra;//����
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  CommodityInformationInfo  _commodityInformationInfo;
		private  IndentInfo  _indentInfo;
		
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
		public String getIndentListId()
		{
		
			 return _indentListId; 
		}
		/**
		*�߼����
		*/
		public void  setIndentListId (String  IndentListId )
		{
			_indentListId = IndentListId ;
		}
		
		
		/**
		*�������
		*/
		public String getIndentId()
		{
		
			 return _indentId; 
		}
		/**
		*�������
		*/
		public void  setIndentId (String  IndentId )
		{
			_indentId = IndentId ;
		}
		
		
		/**
		*��Ʒ���
		*/
		public String getCIId()
		{
		
			 return _cIId; 
		}
		/**
		*��Ʒ���
		*/
		public void  setCIId (String  CIId )
		{
			_cIId = CIId ;
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
		*��Ʒ����
		*/
		public String getCommodityName()
		{
		
			 return _commodityName; 
		}
		/**
		*��Ʒ����
		*/
		public void  setCommodityName (String  CommodityName )
		{
			_commodityName = CommodityName ;
		}
		
		
		/**
		*��Ʒ����
		*/
		public int getNum()
		{
		
			 return _num; 
		}
		/**
		*��Ʒ����
		*/
		public void  setNum (int  Num )
		{
			_num = Num ;
		}
		
		
		/**
		*����
		*/
		public Double getPrice()
		{
		
			 return _price; 
		}
		/**
		*����
		*/
		public void  setPrice (Double  Price )
		{
			_price = Price ;
		}
		
		
		/**
		*����
		*/
		public int getAccumulativelntegra()
		{
		
			 return _accumulativelntegra; 
		}
		/**
		*����
		*/
		public void  setAccumulativelntegra (int  Accumulativelntegra )
		{
			_accumulativelntegra = Accumulativelntegra ;
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
		
	
		
		
		
		public CommodityInformationInfo  getCommodityInformationInfo()
		{
		return _commodityInformationInfo;
		}
		
		public void  setCommodityInformationInfo(CommodityInformationInfo  CommodityInformationInfo)
		{
		 _commodityInformationInfo =CommodityInformationInfo;
		
		}
		
		public IndentInfo  getIndentInfo()
		{
		return _indentInfo;
		}
		
		public void  setIndentInfo(IndentInfo  IndentInfo)
		{
		 _indentInfo =IndentInfo;
		
		}
		
		
				//list FK
  }
 
	
		



