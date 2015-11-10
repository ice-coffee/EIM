
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:��Ʒ��ϸ
	*/
    public class CommodityInformationInfo implements Serializable
    {
        public CommodityInformationInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _commodityInformationId;//�߼����
		/**
		*����
		*/
		private String   _cName;//����
		/**
		*Ʒ��
		*/
		private String   _brand;//Ʒ��
		/**
		*����
		*/
		private String   _typeId;//����
		/**
		*�÷�
		*/
		private String   _scoreListId;//�÷�
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*��Ʒ״̬
		*/
		private String   _state;//��Ʒ״̬
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  TypeMenuInfo  _typeMenuInfo;
		
		//list FK
 private List<AccumulativeIntegraListInfo> _accumulativeIntegraListInfos;
 private List<CommodityDiscountInfo> _commodityDiscountInfos;
 private List<IndentListInfo> _indentListInfos;
		
		
		
		
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
		public String getCommodityInformationId()
		{
		
			 return _commodityInformationId; 
		}
		/**
		*�߼����
		*/
		public void  setCommodityInformationId (String  CommodityInformationId )
		{
			_commodityInformationId = CommodityInformationId ;
		}
		
		
		/**
		*����
		*/
		public String getCName()
		{
		
			 return _cName; 
		}
		/**
		*����
		*/
		public void  setCName (String  CName )
		{
			_cName = CName ;
		}
		
		
		/**
		*Ʒ��
		*/
		public String getBrand()
		{
		
			 return _brand; 
		}
		/**
		*Ʒ��
		*/
		public void  setBrand (String  Brand )
		{
			_brand = Brand ;
		}
		
		
		/**
		*����
		*/
		public String getTypeId()
		{
		
			 return _typeId; 
		}
		/**
		*����
		*/
		public void  setTypeId (String  TypeId )
		{
			_typeId = TypeId ;
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
		*��Ʒ״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*��Ʒ״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
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
		
		
				//list FK
     		public List< AccumulativeIntegraListInfo>  getAccumulativeIntegraListInfos()
		{
		return _accumulativeIntegraListInfos;
		}
		
		public void  setAccumulativeIntegraListInfos(List<AccumulativeIntegraListInfo>  AccumulativeIntegraListInfos)
		{
		 _accumulativeIntegraListInfos =AccumulativeIntegraListInfos;
		
		}
       		public List< CommodityDiscountInfo>  getCommodityDiscountInfos()
		{
		return _commodityDiscountInfos;
		}
		
		public void  setCommodityDiscountInfos(List<CommodityDiscountInfo>  CommodityDiscountInfos)
		{
		 _commodityDiscountInfos =CommodityDiscountInfos;
		
		}
       		public List< IndentListInfo>  getIndentListInfos()
		{
		return _indentListInfos;
		}
		
		public void  setIndentListInfos(List<IndentListInfo>  IndentListInfos)
		{
		 _indentListInfos =IndentListInfos;
		
		}
    }
 
	
		



