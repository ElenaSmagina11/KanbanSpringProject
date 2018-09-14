package com.myproject.dao;

import java.util.ArrayList;
import com.myproject.entity.Kanban;
import com.myproject.model.KanbanInfo;

public interface KanbanDAO {

	public KanbanInfo findKanbanInfo(String userName, String jobName);

	public void save(KanbanInfo kanbanInfo);

	Kanban findKanban(String userName, String jobName);

	ArrayList<Kanban> findKanbanListByUserName(String userName);

	public void remove(String userName, String jobName);

	public java.util.List<Kanban> getAll(String userName);// not use---for JPA

}