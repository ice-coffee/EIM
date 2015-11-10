
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*备注:图片列表
	*/
    public class PictureListInfo implements Serializable
    {
        public PictureListInfo()
        { }
		
		
		/**
		*编号
		*/
		private String   _id;//编号
		/**
		*图片信息IdJson形式保存
		*/
		private String   _pictrueList;//图片信息IdJson形式保存
		
		//list FK
 private List<PictrueInformationInfo> _pictrueInformationInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
    private List<OfUser> _ofUser1s;
    private List<OfUser> _ofUser2s;
		
		
		
		
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
		*图片信息IdJson形式保存
		*/
		public String getPictrueList()
		{
		
			 return _pictrueList; 
		}
		/**
		*图片信息IdJson形式保存
		*/
		public void  setPictrueList (String  PictrueList )
		{
			_pictrueList = PictrueList ;
		}
		
	
		
		
		
		
				//list FK
     		public List< PictrueInformationInfo>  getPictrueInformationInfos()
		{
		return _pictrueInformationInfos;
		}
		
		public void  setPictrueInformationInfos(List<PictrueInformationInfo>  PictrueInformationInfos)
		{
		 _pictrueInformationInfos =PictrueInformationInfos;
		
		}
       		public List< ShopInformationInfo>  getShopInformationInfos()
		{
		return _shopInformationInfos;
		}
		
		public void  setShopInformationInfos(List<ShopInformationInfo>  ShopInformationInfos)
		{
		 _shopInformationInfos =ShopInformationInfos;
		
		}
    	public List< OfUser>  getOfUser1s()
		{
		return _ofUser1s;
		}
		
		public void  setOfUser1s(List<OfUser>  OfUser1s)
		{
		 _ofUser1s =OfUser1s;
		
		}
	public List< OfUser>  getOfUser2s()
		{
		return _ofUser2s;
		}
		
		public void  setOfUser2s(List<OfUser>  OfUser2s)
		{
		 _ofUser2s =OfUser2s;
		
		}
}
 
	
		



