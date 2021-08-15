package com.sankdev.service;

import com.sankdev.dao.PortfolioDAO;
import com.sankdev.portfolio.Item;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PortfolioService {

  private PortfolioDAO portfolioDAO;

  public PortfolioService() {
    this.portfolioDAO = new PortfolioDAO();
  }

  public List<Item> getItems() {
    return this.portfolioDAO.getItems();
  }

  public void setItems(List<Item> items) {
    this.portfolioDAO.setItems(items);
  }

  public void addItem(Item item) {
    portfolioDAO.addItem(item);
  }

  public void removeItem(Item item) {
    portfolioDAO.removeItem(item);
  }

  public void saveItems(File file) throws IOException {
    portfolioDAO.saveItems(file);
  }

  public void loadItems(File file) throws IOException, ClassNotFoundException {
    portfolioDAO.loadItems(file);
  }

}
