
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:ͼƬ�б�
	*/
    public class PictureListInfo implements Serializable
    {
        public PictureListInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*ͼƬ��ϢIdJson��ʽ����
		*/
		private String   _pictrueList;//ͼƬ��ϢIdJson��ʽ����
		
		//list FK
 private List<PictrueInformationInfo> _pictrueInformationInfos;
 private List<ShopInformationInfo> _shopInformationInfos;
    private List<OfUser> _ofUser1s;
    private List<OfUser> _ofUser2s;
		
		
		
		
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
		*ͼƬ��ϢIdJson��ʽ����
		*/
		public String getPictrueList()
		{
		
			 return _pictrueList; 
		}
		/**
		*ͼƬ��ϢIdJson��ʽ����
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
 
	
		



