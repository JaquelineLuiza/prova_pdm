package br.edu.iftm.pdm.patrimonizador.data;

public class DBSchema {

    public static final class ImagemT {
        public static final String TABELA = "imagem";
        public static final String ID = "i_id";
        public static final String PATH = "i_path";
        public static final String PID = "i_pid";

        public static final String getCreationQuery() {
            // TODO (1) você deverá implementar a query de criação da tabela imagem OK
            String sqlImagem = "CREATE TABLE IF NOT EXISTS " + TABELA + "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    PATH+" TEXT NOT NULL, "+
                    PID+" TEXT NOT NULL);";
            return sqlImagem;
        }
    }

    public static final class PatrimonioT {

        public static final String TABELA = "patrimonio";
        public static final String VIEWSELECTION = "p_get_patrimonio";

        public static final String ID = "p_id";
        public static final String CATEGORIA = "p_categoria";
        public static final String MARCA = "p_marca";
        public static final String ESTADO = "p_estado";
        public static final String VALOR = "p_valor";
        public static final String DESCRICAO = "p_descricao";
        public static final String TIMESTAMP = "p_timestamp";

        public static final String getCreationQuery() {
            // TODO (2) você deverá implementar a query de criação da tabela patrimonio OK
            String sqlPatrimonio = "CREATE TABLE IF NOT EXISTS " + TABELA + "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    CATEGORIA+" TEXT NOT NULL, " +
                    MARCA+" TEXT NOT NULL, "+
                    ESTADO+" TEXT NOT NULL, "+
                    VALOR+" FLOAT, "+
                    DESCRICAO+" TEXT NOT NULL, "+
                    TIMESTAMP+" DATETIME DEFAULT CURRENT_TIMESTAMP);";
            return sqlPatrimonio;
        }

        public static final String getViewCreationQuery() {
            //TODO (3) você deverá implementar a query de criação de uma view de seleção para patrimonio.
            // Nesta view você deverá criar a selecão da relação patrimonio-imagem. OK
            return "CREATE VIEW IF NOT EXISTS " + VIEWSELECTION
                    + " AS SELECT * FROM " + PatrimonioT.TABELA + " JOIN " + ImagemT.TABELA
                    + " ON " + ID + " = " + ImagemT.PID + ";";
        }
    }
}
