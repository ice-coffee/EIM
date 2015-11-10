
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:����
	*/
    public class IndentInfo implements Serializable
    {
        public IndentInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _indentId;//�߼����
		/**
		*�̼ұ��
		*/
		private String   _shopId;//�̼ұ��
		/**
		*�µ���
		*/
		private String   _userId;//�µ���
		/**
		*��ַ
		*/
		private String   _userAddress;//��ַ
		/**
		*�绰
		*/
		private String   _tel;//�绰
		/**
		*�û�����
		*/
		private String   _userName;//�û�����
		/**
		*�µ�ʱ��
		*/
		private String   _indentDate;//�µ�ʱ��
		/**
		*���۵÷�
		*/
		private String   _scoreId;//���۵÷�
		/**
		*ȡ��ʱ��
		*/
		private String   _getDate;//ȡ��ʱ��
		/**
		*j�������ʱ��
		*/
		private String   _overDate;//j�������ʱ��
		/**
		*״̬
		*/
		private String   _state;//״̬
		/**
		*�Ƿ񸶿�(0=false��1=true)
		*/
		private int   _whetherPayment;//�Ƿ񸶿�(0=false��1=true)
		/**
		*�Ƿ���ɽ���(0=false��1=true)
		*/
		private int   _whetherCompleteTransaction;//�Ƿ���ɽ���(0=false��1=true)
		/**
		*�Ƿ��˻�(0=false��1=true)
		*/
		private int   _whetherReturn;//�Ƿ��˻�(0=false��1=true)
		/**
		*��ע
		*/
		private String   _remark;//��ע
		/**
		*Ԥ���ֶ�
		*/
		private String   _field;//Ԥ���ֶ�
		private  ShopInformationInfo  _shopInformationInfo;
		private  OfUser  _ofUser;
		
		//list FK
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
		public String getIndentId()
		{
		
			 return _indentId; 
		}
		/**
		*�߼����
		*/
		public void  setIndentId (String  IndentId )
		{
			_indentId = IndentId ;
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
		*�µ���
		*/
		public String getUserId()
		{
		
			 return _userId; 
		}
		/**
		*�µ���
		*/
		public void  setUserId (String  UserId )
		{
			_userId = UserId ;
		}
		
		
		/**
		*��ַ
		*/
		public String getUserAddress()
		{
		
			 return _userAddress; 
		}
		/**
		*��ַ
		*/
		public void  setUserAddress (String  UserAddress )
		{
			_userAddress = UserAddress ;
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
		*�û�����
		*/
		public String getUserName()
		{
		
			 return _userName; 
		}
		/**
		*�û�����
		*/
		public void  setUserName (String  UserName )
		{
			_userName = UserName ;
		}
		
		
		/**
		*�µ�ʱ��
		*/
		public String getIndentDate()
		{
		
			 return _indentDate; 
		}
		/**
		*�µ�ʱ��
		*/
		public void  setIndentDate (String  IndentDate )
		{
			_indentDate = IndentDate ;
		}
		
		
		/**
		*���۵÷�
		*/
		public String getScoreId()
		{
		
			 return _scoreId; 
		}
		/**
		*���۵÷�
		*/
		public void  setScoreId (String  ScoreId )
		{
			_scoreId = ScoreId ;
		}
		
		
		/**
		*ȡ��ʱ��
		*/
		public String getGetDate()
		{
		
			 return _getDate; 
		}
		/**
		*ȡ��ʱ��
		*/
		public void  setGetDate (String  GetDate )
		{
			_getDate = GetDate ;
		}
		
		
		/**
		*j�������ʱ��
		*/
		public String getOverDate()
		{
		
			 return _overDate; 
		}
		/**
		*j�������ʱ��
		*/
		public void  setOverDate (String  OverDate )
		{
			_overDate = OverDate ;
		}
		
		
		/**
		*״̬
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*״̬
		*/
		public void  setState (String  State )
		{
			_state = State ;
		}
		
		
		/**
		*�Ƿ񸶿�(0=false��1=true)
		*/
		public int getWhetherPayment()
		{
		
			 return _whetherPayment; 
		}
		/**
		*�Ƿ񸶿�(0=false��1=true)
		*/
		public void  setWhetherPayment (int  WhetherPayment )
		{
			_whetherPayment = WhetherPayment ;
		}
		
		
		/**
		*�Ƿ���ɽ���(0=false��1=true)
		*/
		public int getWhetherCompleteTransaction()
		{
		
			 return _whetherCompleteTransaction; 
		}
		/**
		*�Ƿ���ɽ���(0=false��1=true)
		*/
		public void  setWhetherCompleteTransaction (int  WhetherCompleteTransaction )
		{
			_whetherCompleteTransaction = WhetherCompleteTransaction ;
		}
		
		
		/**
		*�Ƿ��˻�(0=false��1=true)
		*/
		public int getWhetherReturn()
		{
		
			 return _whetherReturn; 
		}
		/**
		*�Ƿ��˻�(0=false��1=true)
		*/
		public void  setWhetherReturn (int  WhetherReturn )
		{
			_whetherReturn = WhetherReturn ;
		}
		
		
		/**
		*��ע
		*/
		public String getRemark()
		{
		
			 return _remark; 
		}
		/**
		*��ע
		*/
		public void  setRemark (String  Remark )
		{
			_remark = Remark ;
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
		
		public OfUser  getOfUser()
		{
		return _ofUser;
		}
		
		public void  setOfUser(OfUser  OfUser)
		{
		 _ofUser =OfUser;
		
		}
		
		
				//list FK
     		public List< IndentListInfo>  getIndentListInfos()
		{
		return _indentListInfos;
		}
		
		public void  setIndentListInfos(List<IndentListInfo>  IndentListInfos)
		{
		 _indentListInfos =IndentListInfos;
		
		}
    }
 
	
		



