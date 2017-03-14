package fr.unice.polytech.a.ihm.g2c.model;

import fr.unice.polytech.a.ihm.g2c.common.Category;
import fr.unice.polytech.a.ihm.g2c.common.Language;
import fr.unice.polytech.a.ihm.g2c.common.SortingType;
import fr.unice.polytech.a.ihm.g2c.common.Stylesheet;

import java.util.*;

/**
 * Created by user on 08/03/2017.
 */
public class DataModel {

    private static DataModel instance = new DataModel();

    private Language lang;
    private ResourceBundle langBundle;
    private String stylesheet = Stylesheet.BIG.toString();

    private List<Store> storeList = new ArrayList<>();
    private List<Store> storeSelectionList = new ArrayList<>();
    private String highlight;
    private List<Category> categoryFilter = new ArrayList<>();
    private SortingType sortingType = SortingType.A_TO_Z;
    private String search = "";
    private String informations = "";

    private DataModel() {
        if (instance != null)
            throw new IllegalStateException();
        setLang(Language.FR);
    }

    public static DataModel getInstance() {
        return instance;
    }

    public void addStore(Store store) {
        storeList.add(store);
    }

    public void removeStore(Store store) {
        storeList.remove(store);
    }

    public List<Store> getStoreList() {
        return new LinkedList<>(storeList);
    }

    public List<Store> getStoreSelectionList() {
        return new ArrayList<>(storeSelectionList);
    }

    public void setStoreSelectionList(List<Store> storeSelectionList) {
        this.storeSelectionList = storeSelectionList;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public List<Category> getCategoryFilter() {
        return categoryFilter;
    }

    public SortingType getSortingType() {
        return sortingType;
    }

    public void setSortingType(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getInformations() {
        if (informations.isEmpty())
            return langBundle.getString("description");
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
        langBundle = ResourceBundle.getBundle("properties.lang", lang.getLocale());
    }

    public ResourceBundle getLangBundle() {
        return langBundle;
    }

    public String getStylesheet() {
        return stylesheet;
    }
}
