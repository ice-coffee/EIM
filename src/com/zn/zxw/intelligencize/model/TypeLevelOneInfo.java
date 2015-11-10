
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*±¸×¢:Ò»¼¶Àà±ð±í
	*/
    public class TypeLevelOneInfo implements Serializable
    {
        public TypeLevelOneInfo()
        { }
		
		
		/**
		*±àºÅ
		*/
		private String   _id;//±àºÅ
		/**
		*Ãû³Æ
		*/
		private String   _name;//Ãû³Æ
		/**
		*ÅÅÐò
		*/
		private int   _order;//ÅÅÐò
		/**
		*×´Ì¬
		*/
		private int   _state;//×´Ì¬
		/**
		*ÃèÊö
		*/
		private String   _describe;//ÃèÊö
		
		//list FK
 private List<CommodityDiscountInfo> _commodityDiscountInfos;
 private List<OfUser> _ofUsers;
		
		
		
		
		/**
		*±àºÅ
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*±àºÅ
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*Ãû³Æ
		*/
		public String getName()
		{
		
			 return _name; 
		}
		/**
		*Ãû³Æ
		*/
		public void  setName (String  Name )
		{
			_name = Name ;
		}
		
		
		/**
		*ÅÅÐò
		*/
		public int getOrder()
		{
		
			 return _order; 
		}
		/**
		*ÅÅÐò
		*/
		public void  setOrder (int  Order )
		{
			_order = Order ;
		}
		
		
		/**
		*×´Ì¬
		*/
		public int getState()
		{
		
			 return _state; 
		}
		/**
		*×´Ì¬
		*/
		public void  setState (int  State )
		{
			_state = State ;
		}
		
		
		/**
		*ÃèÊö
		*/
		public String getDescribe()
		{
		
			 return _describe; 
		}
		/**
		*ÃèÊö
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
 
	
		



