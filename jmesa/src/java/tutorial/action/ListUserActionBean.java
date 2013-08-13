/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.action;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.limit.Order;
import org.jmesa.limit.Sort;
import org.jmesa.limit.SortSet;
import org.jmesa.util.ItemUtils;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;
import tutorial.dao.Users;
import tutorial.model.User;

/**
 *
 * @author hantsy
 */
public class ListUserActionBean extends BaseActionBean {

    private List<User> users;
    private String html;
    private String id = "users_table";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @DefaultHandler
    public Resolution listUsers() {

        TableFacade tableFacade = TableFacadeFactory.createTableFacade(id, getContext().getRequest());
        tableFacade.setColumnProperties("id", "firstname", "lastname", "action");

        tableFacade.setMaxRows(5);
        tableFacade.setMaxRowsIncrements(5, 10);
        tableFacade.autoFilterAndSort(true);
        tableFacade.setStateAttr("state");

        Limit limit = tableFacade.getLimit();
        if (!limit.isComplete()) {
            int totalRows = Users.getUserList().size();
            tableFacade.setTotalRows(totalRows);
        }
        int rowEnd = limit.getRowSelect().getRowEnd();
        int rowStart = limit.getRowSelect().getRowStart();
        users = Users.subList(rowStart, rowEnd - rowStart);
        
        final SortSet sortSet = limit.getSortSet();
        if (sortSet != null) {
            Sort firstnameSort = sortSet.getSort("firstname");
            if (firstnameSort != null && firstnameSort.getOrder() != Order.NONE) {
                Collections.sort(users, new FirstnameComparator());
                if (firstnameSort.getOrder() == Order.DESC) {
                    Collections.reverse(users);
                }
            }

            Sort lastnameSort = sortSet.getSort("lastname");
            if (lastnameSort != null && lastnameSort.getOrder() != Order.NONE) {
                Collections.sort(users, new LastnameComparator());
                if (lastnameSort.getOrder() == Order.DESC) {
                    Collections.reverse(users);
                }
            }
        }



        // users = Users.subList(rowStart, rowEnd - rowStart);
        tableFacade.setItems(users);

        HtmlTable table = (HtmlTable) tableFacade.getTable();
        //table.setCaption("Presidents");
        table.getTableRenderer().setWidth("600px");

        HtmlRow row = table.getRow();

        HtmlColumn userid = row.getColumn("id");
        userid.setTitle("User ID");
        userid.setSortable(false);

        HtmlColumn firstName = row.getColumn("firstname");
        firstName.setTitle("First Name");


        HtmlColumn lastName = row.getColumn("lastname");
        lastName.setTitle("Last Name");


        HtmlColumn action = row.getColumn("action");
        action.setTitle("Action");
        action.setFilterable(false);
        action.setSortable(false);

        action.getCellRenderer().setCellEditor(new CellEditor() {

            public Object getValue(Object item, String property, int rowcount) {
                Object value = ItemUtils.getItemValue(item, "id");
                HtmlBuilder html = new HtmlBuilder();
                html.a().href().quote().append(getContext().getServletContext().getContextPath()).append("/EditUser.action?id=").append(value).quote().close();
                html.append("Edit");
                html.aEnd();
                html.append("&nbsp;");
                html.a().href().quote().append(getContext().getServletContext().getContextPath()).append("/DeleteUser.action?id=").append(value).quote().close();
                html.append("Delete");
                html.aEnd();
                return html.toString();
            }
        });

        html = tableFacade.render();
        return new ForwardResolution("/userList.jsp");
    }

    class FirstnameComparator implements Comparator<User> {

        public int compare(User o1, User o2) {
            return o1.getFirstname().compareTo(o2.getFirstname());
        }
    }

    class LastnameComparator implements Comparator<User> {

        public int compare(User o1, User o2) {
            return o1.getLastname().compareTo(o2.getLastname());
        }
    }
}
