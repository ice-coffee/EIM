
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:���̼һ�����Ϣ���
	*/
    public class ShopAcceptInfo implements Serializable
    {
        public ShopAcceptInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*�߼����
		*/
		private String   _shopAcceptId;//�߼����
		/**
		*��������
		*/
		private int   _sanitation;//��������
		/**
		*��Ʒ��ʵ
		*/
		private int   _commodity;//��Ʒ��ʵ
		/**
		*�������
		*/
		private int   _community;//�������
		/**
		*ƽ̨���
		*/
		private int   _platform;//ƽ̨���
		/**
		*״̬
		*/
		private String   _state;//״̬
		
		//list FK
 private List<ShopInformationInfo> _shopInformationInfos;
		
		
		
		
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
		public String getShopAcceptId()
		{
		
			 return _shopAcceptId; 
		}
		/**
		*�߼����
		*/
		public void  setShopAcceptId (String  ShopAcceptId )
		{
			_shopAcceptId = ShopAcceptId ;
		}
		
		
		/**
		*��������
		*/
		public int getSanitation()
		{
		
			 return _sanitation; 
		}
		/**
		*��������
		*/
		public void  setSanitation (int  Sanitation )
		{
			_sanitation = Sanitation ;
		}
		
		
		/**
		*��Ʒ��ʵ
		*/
		public int getCommodity()
		{
		
			 return _commodity; 
		}
		/**
		*��Ʒ��ʵ
		*/
		public void  setCommodity (int  Commodity )
		{
			_commodity = Commodity ;
		}
		
		
		/**
		*�������
		*/
		public int getCommunity()
		{
		
			 return _community; 
		}
		/**
		*�������
		*/
		public void  setCommunity (int  Community )
		{
			_community = Community ;
		}
		
		
		/**
		*ƽ̨���
		*/
		public int getPlatform()
		{
		
			 return _platform; 
		}
		/**
		*ƽ̨���
		*/
		public void  setPlatform (int  Platform )
		{
			_platform = Platform ;
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
		
	
		
		
		
		
				//list FK
     		public List< ShopInformationInfo>  getShopInformationInfos()
		{
		return _shopInformationInfos;
		}
		
		public void  setShopInformationInfos(List<ShopInformationInfo>  ShopInformationInfos)
		{
		 _shopInformationInfos =ShopInformationInfos;
		
		}
    }
 
	
		



