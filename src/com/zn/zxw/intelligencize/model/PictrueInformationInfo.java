
package  com.zn.zxw.intelligencize.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
  	/**
	*��ע:ͼƬ��Ϣ
	*/
    public class PictrueInformationInfo implements Serializable
    {
        public PictrueInformationInfo()
        { }
		
		
		/**
		*���
		*/
		private String   _id;//���
		/**
		*ͼƬ
		*/
		private byte[]   _picture;//ͼƬ
		/**
		*�ϴ�ʱ��
		*/
		private String   _upDate;//�ϴ�ʱ��
		/**
		*����
		*/
		private String   _describe;//����
		/**
		*ͼƬ�б�Id
		*/
		private String   _pictureListId;//ͼƬ�б�Id
		
		//list FK
		
		
		
		
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
		*ͼƬ
		*/
		public byte[] getPicture()
		{
		
			 return _picture; 
		}
		/**
		*ͼƬ
		*/
		public void  setPicture (byte[]  Picture )
		{
			_picture = Picture ;
		}
		
		
		/**
		*�ϴ�ʱ��
		*/
		public String getUpDate()
		{
		
			 return _upDate; 
		}
		/**
		*�ϴ�ʱ��
		*/
		public void  setUpDate (String  UpDate )
		{
			_upDate = UpDate ;
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
		*ͼƬ�б�Id
		*/
		public String getPictureListId()
		{
		
			 return _pictureListId; 
		}
		/**
		*ͼƬ�б�Id
		*/
		public void  setPictureListId (String  PictureListId )
		{
			_pictureListId = PictureListId ;
		}
		
		
	
		
				//list FK
  }
 
	
		



