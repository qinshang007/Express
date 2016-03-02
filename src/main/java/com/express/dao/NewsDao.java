package com.express.dao;

import java.util.List;

import com.express.bean.News;

public interface NewsDao {
	
	/* 查询表中大类下的新闻 */
    public List<News> getNewsListByNewsType(int newstype);
    
    /* 根据大类型号和之类型号查询子类下新闻*/
    public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype);  
    
    /* 根据newsid查询指定新闻 */
    public News getByNewsId(String newsid); 
    
    /* 添加新闻*/
    public boolean addNews(News news);
    
    /* 更新新闻*/
    public boolean updateNews(News news);
    
    /* 删除新闻*/
    public boolean deleteNews(String newsid);
}
