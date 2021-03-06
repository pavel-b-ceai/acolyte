package acolyte.jdbc;

import java.util.List;

import java.sql.SQLException;
import java.sql.ResultSet;

import org.apache.commons.lang3.tuple.Pair;

import acolyte.jdbc.ParameterMetaData.ParameterDef;

/**
 * Statement handler: allow to process statement by 'hand' and return.
 *
 * @author Cedric Chantepie
 */
public interface StatementHandler {
    /**
     * When given |sql| query is executed against Acolyte connection ...
     *
     * @param sql SQL query (with '?' for prepared/callable statement)
     * @param parameters Parameters (or empty map if none)
     * @return Query result set
     */
    public QueryResult whenSQLQuery(String sql, List<Parameter> parameters) 
        throws SQLException;

    /**
     * When given |sql| update is executed against Acolyte connection ...
     *
     * @param sql SQL query (with '?' for prepared/callable statement)
     * @param parameters Parameters (or empty map if none)
     * @return Row count
     */
    public UpdateResult whenSQLUpdate(String sql, List<Parameter> parameters) 
        throws SQLException;

    /**
     * If statement is neither a PreparedStatement nor a CallbableStatement,
     * determines whether given |sql| is a query.
     *
     * If returns true, whenSQLQuery will be called.
     */
    public boolean isQuery(String sql);

    // --- Inner classes ---

    /**
     * Meaningful, user-friendly and immutable type alias 
     * for ugly Pair<ParameterDef,Object>
     */
    public final class Parameter extends Pair<ParameterDef,Object> {
        public final ParameterDef left;
        public final Object right;
        
        // --- Constructors ---

        /**
         * Copy constructor.
         */
        private Parameter(final ParameterDef left, final Object right) {
            this.left = left;
            this.right = right;
        } // end of <init>

        // ---

        /**
         * Returns parameter made of |left| and |right| datas.
         */
        public static Parameter of(final ParameterDef left, 
                                   final Object right) {

            return new Parameter(left, right);
        } // end of of

        /**
         * {@inheritDoc}
         */
        public ParameterDef getLeft() {
            return this.left;
        } // end of getLeft

        /**
         * {@inheritDoc}
         */
        public Object getRight() {
            return this.right;
        } // end of getRight

        /**
         * {@inheritDoc}
         */
        public Object getValue() {
            return this.right;
        } // end of getValue

        /**
         * @throws UnsupportedOperationException
         */
        public Object setValue(final Object value) {
            throw new UnsupportedOperationException();
        } // end of setValue

        /**
         * Compares this parameter with an|other| one.
         */
        public int compareTo(final Parameter other) {
            return super.compareTo(other);
        } // end of compareTo

        /**
         * {@inheritDoc}
         */
        public boolean equals(final Object o) {
            if (o == null || !(o instanceof Parameter)) {
                return false;
            } // end of if

            return super.equals(o);
        } // end of equals
        
        /**
         * {@inheritDoc}
         */
        public int hashCode() {
            return super.hashCode();
        } // end of hashCode

        /**
         * {@inheritDoc}
         */
        public String toString() {
            return super.toString();
        } // end of toString

        /**
         * {@inheritDoc}
         */
        public String toString(final String format) {
            return super.toString(format);
        } // end of toString
    } // end of class Parameter
} // end of interface StatementHandler
