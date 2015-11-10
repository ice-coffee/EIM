
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:对商家基本信息审核
	*/
    public class ShopAcceptInfo implements Serializable
    {
        public ShopAcceptInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*逻辑编号
		*/
		private String   _shopAcceptId;//逻辑编号
		/**
		*环境卫生
		*/
		private int   _sanitation;//环境卫生
		/**
		*产品属实
		*/
		private int   _commodity;//产品属实
		/**
		*社区审核
		*/
		private int   _community;//社区审核
		/**
		*平台审核
		*/
		private int   _platform;//平台审核
		/**
		*状态
		*/
		private String   _state;//状态
		
		//list FK
 private List<ShopInformationInfo> _shopInformationInfos;
		
		
		
		
		/**
		*编号
		*/
		public String getId()
		{
		
			 return _id; 
		}
		/**
		*编号
		*/
		public void  setId (String  Id )
		{
			_id = Id ;
		}
		
		
		/**
		*逻辑编号
		*/
		public String getShopAcceptId()
		{
		
			 return _shopAcceptId; 
		}
		/**
		*逻辑编号
		*/
		public void  setShopAcceptId (String  ShopAcceptId )
		{
			_shopAcceptId = ShopAcceptId ;
		}
		
		
		/**
		*环境卫生
		*/
		public int getSanitation()
		{
		
			 return _sanitation; 
		}
		/**
		*环境卫生
		*/
		public void  setSanitation (int  Sanitation )
		{
			_sanitation = Sanitation ;
		}
		
		
		/**
		*产品属实
		*/
		public int getCommodity()
		{
		
			 return _commodity; 
		}
		/**
		*产品属实
		*/
		public void  setCommodity (int  Commodity )
		{
			_commodity = Commodity ;
		}
		
		
		/**
		*社区审核
		*/
		public int getCommunity()
		{
		
			 return _community; 
		}
		/**
		*社区审核
		*/
		public void  setCommunity (int  Community )
		{
			_community = Community ;
		}
		
		
		/**
		*平台审核
		*/
		public int getPlatform()
		{
		
			 return _platform; 
		}
		/**
		*平台审核
		*/
		public void  setPlatform (int  Platform )
		{
			_platform = Platform ;
		}
		
		
		/**
		*状态
		*/
		public String getState()
		{
		
			 return _state; 
		}
		/**
		*状态
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
 
	
		



