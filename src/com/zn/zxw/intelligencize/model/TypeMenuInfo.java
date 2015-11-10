
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:���
	*/
    public class TypeMenuInfo implements Serializable
    {
        public TypeMenuInfo()
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
		*��ǰ����
		*/
		private int   _level;//��ǰ����
		/**
		*����
		*/
		private int   _order;//����
		/**
		*����Id
		*/
		private String   _parentId;//����Id
		/**
		*״̬
		*/
		private int   _state;//״̬
		/**
		*����
		*/
		private String   _describe;//����
		
		//list FK
 private List<ActivitySchemeInfo> _activitySchemeInfos;
 private List<ChatGroupInfo> _chatGroupInfos;
 private List<CommodityInformationInfo> _commodityInformationInfos;
 private List<ObjectScoreInfo> _objectScoreInfos;
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
		*��ǰ����
		*/
		public int getLevel()
		{
		
			 return _level; 
		}
		/**
		*��ǰ����
		*/
		public void  setLevel (int  Level )
		{
			_level = Level ;
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
		*����Id
		*/
		public String getParentId()
		{
		
			 return _parentId; 
		}
		/**
		*����Id
		*/
		public void  setParentId (String  ParentId )
		{
			_parentId = ParentId ;
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
     		public List< ActivitySchemeInfo>  getActivitySchemeInfos()
		{
		return _activitySchemeInfos;
		}
		
		public void  setActivitySchemeInfos(List<ActivitySchemeInfo>  ActivitySchemeInfos)
		{
		 _activitySchemeInfos =ActivitySchemeInfos;
		
		}
       		public List< ChatGroupInfo>  getChatGroupInfos()
		{
		return _chatGroupInfos;
		}
		
		public void  setChatGroupInfos(List<ChatGroupInfo>  ChatGroupInfos)
		{
		 _chatGroupInfos =ChatGroupInfos;
		
		}
       		public List< CommodityInformationInfo>  getCommodityInformationInfos()
		{
		return _commodityInformationInfos;
		}
		
		public void  setCommodityInformationInfos(List<CommodityInformationInfo>  CommodityInformationInfos)
		{
		 _commodityInformationInfos =CommodityInformationInfos;
		
		}
       		public List< ObjectScoreInfo>  getObjectScoreInfos()
		{
		return _objectScoreInfos;
		}
		
		public void  setObjectScoreInfos(List<ObjectScoreInfo>  ObjectScoreInfos)
		{
		 _objectScoreInfos =ObjectScoreInfos;
		
		}
       		public List< ShopInformationInfo>  getShopInformationInfos()
		{
		return _shopInformationInfos;
		}
		
		public void  setShopInformationInfos(List<ShopInformationInfo>  ShopInformationInfos)
		{
		 _shopInformationInfos =ShopInformationInfos;
		
		}
    }
 
	
		



