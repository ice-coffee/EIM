
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:һ������
	*/
    public class TypeLevelOneInfo implements Serializable
    {
        public TypeLevelOneInfo()
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
		*����
		*/
		private int   _order;//����
		/**
		*״̬
		*/
		private int   _state;//״̬
		/**
		*����
		*/
		private String   _describe;//����
		
		//list FK
 private List<CommodityDiscountInfo> _commodityDiscountInfos;
 private List<OfUser> _ofUsers;
		
		
		
		
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
		
		
		/**
		*״̬
		*/
		public int getState()
		{
		
			 return _state; 
		}
		/**
		*״̬
		*/
		public void  setState (int  State )
		{
			_state = State ;
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
		
	
		
		
		
		
				//list FK
     		public List< CommodityDiscountInfo>  getCommodityDiscountInfos()
		{
		return _commodityDiscountInfos;
		}
		
		public void  setCommodityDiscountInfos(List<CommodityDiscountInfo>  CommodityDiscountInfos)
		{
		 _commodityDiscountInfos =CommodityDiscountInfos;
		
		}
       		public List< OfUser>  getOfUsers()
		{
		return _ofUsers;
		}
		
		public void  setOfUsers(List<OfUser>  OfUsers)
		{
		 _ofUsers =OfUsers;
		
		}
    }
 
	
		



