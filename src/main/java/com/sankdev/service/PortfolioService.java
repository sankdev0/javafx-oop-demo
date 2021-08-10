package com.sankdev.service;

import com.sankdev.dao.PortfolioDAO;
import com.sankdev.portfolio.Item;
import java.io.IOException;
import javafx.collections.ObservableList;

public class PortfolioService {

  private PortfolioDAO portfolioDAO;

  public PortfolioService() {
    this.portfolioDAO = PortfolioDAO.getInstance();
  }

  public ObservableList<Item> getItems() {
    return this.portfolioDAO.getObservableItems();
  }

  public void addItem(Item item) {
    portfolioDAO.addItem(item);
  }

  public void writePortfolio() throws IOException {
    portfolioDAO.writePortfolio();
  }

  public void readPortfolio() throws IOException, ClassNotFoundException {
    portfolioDAO.readPortfolio(); // changes the INSTANCE!
    this.portfolioDAO = PortfolioDAO.getInstance();
  }

}
