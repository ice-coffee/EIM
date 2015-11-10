
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:����ˮ�ѣ���ѣ�ȼ����
	*/
    public class DealTypeInfo implements Serializable
    {
        public DealTypeInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _dealTypeId;//�߼����
		/**
		*�ɷ�����
		*/
		private String   _name;//�ɷ�����
		/**
		*������λ
		*/
		private String   _unit;//������λ
		/**
		*����
		*/
		private Double   _price;//����
		/**
		*����
		*/
		private Double   _dosage;//����
		/**
		*���
		*/
		private Double   _money;//���
		/**
		*�ɷ��¶�
		*/
		private String   _month;//�ɷ��¶�
		/**
		*ÿ��ʲôʱ���¼����
		*/
		private String   _operateDate;//ÿ��ʲôʱ���¼����
		/**
		*�Ƿ��Ѹ���
		*/
		private int   _ifPay;//�Ƿ��Ѹ���
		/**
		*���ɽ�
		*/
		private Double   _overdueFine;//���ɽ�
		/**
		*��¼������
		*/
		private String   _userId;//��¼������
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  OfUser  _ofUser;
		
		//list FK
 private List<DealInfo> _dealInfos;
		
		
		
		
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
		public String getDealTypeId()
		{
		
			 return _dealTypeId; 
		}
		/**
		*�߼����
		*/
		public void  setDealTypeId (String  DealTypeId )
		{
			_dealTypeId = DealTypeId ;
		}
		
		
		/**
		*�ɷ�����
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*�ɷ�����
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*������λ
		*/
		public String getUnit()
		{
		
			 return _unit; 
		}
		/**
		*������λ
		*/
		public void  setUnit (String  Unit )
		{
			_unit = Unit ;
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
		public Double getDosage()
		{
		
			 return _dosage; 
		}
		/**
		*����
		*/
		public void  setDosage (Double  Dosage )
		{
			_dosage = Dosage ;
		}
		
		
		/**
		*���
		*/
		public Double getMoney()
		{
		
			 return _money; 
		}
		/**
		*���
		*/
		public void  setMoney (Double  Money )
		{
			_money = Money ;
		}
		
		
		/**
		*�ɷ��¶�
		*/
		public String getMonth()
		{
		
			 return _month; 
		}
		/**
		*�ɷ��¶�
		*/
		public void  setMonth (String  Month )
		{
			_month = Month ;
		}
		
		
		/**
		*ÿ��ʲôʱ���¼����
		*/
		public String getOperateDate()
		{
		
			 return _operateDate; 
		}
		/**
		*ÿ��ʲôʱ���¼����
		*/
		public void  setOperateDate (String  OperateDate )
		{
			_operateDate = OperateDate ;
		}
		
		
		/**
		*�Ƿ��Ѹ���
		*/
		public int getIfPay()
		{
		
			 return _ifPay; 
		}
		/**
		*�Ƿ��Ѹ���
		*/
		public void  setIfPay (int  IfPay )
		{
			_ifPay = IfPay ;
		}
		
		
		/**
		*���ɽ�
		*/
		public Double getOverdueFine()
		{
		
			 return _overdueFine; 
		}
		/**
		*���ɽ�
		*/
		public void  setOverdueFine (Double  OverdueFine )
		{
			_overdueFine = OverdueFine ;
		}
		
		
		/**
		*��¼������
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*��¼������
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
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
		
		
				//list FK
     		public List< DealInfo>  getDealInfos()
		{
		return _dealInfos;
		}
		
		public void  setDealInfos(List<DealInfo>  DealInfos)
		{
		 _dealInfos =DealInfos;
		
		}
    }
 
	
		



