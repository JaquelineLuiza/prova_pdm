package br.edu.iftm.pdm.patrimonizador.data;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.activities.MainActivity;

public class FileManager {

    private static final String CSVHEADER = "id,categoria,marca,estado,valor,timestamp,descricao\n";

    public static File createImageFile() throws IOException {
        //TODO (5) Implementar método para criação de arquivos onde serão guardadas as imagens
        // capturadas pelo aplicativo.
        // Aqui você deverá gerar um arquivo com nome único auto gerável.
        // O arquivo deve ser guardado no armazenamento externo do dispositivo.

        return null;
    }

    public static String getHeader() {
        return CSVHEADER;
    }

    public static String patrimonioToCSVLine(Patrimonio patrimonio) {
        //TODO (6) Implementar um método que transforma um objeto patrimonio
        // em uma String no formato CSV. O CSV é representado por uma característica
        // de linhas e colunas. As linhas são definidas pelo caractére \n
        // enquanto que as colunas são delimitadas pelo caractére de vírgula.

        // Veja o documento informativo que acompanha este código para ver a formatação
        // dos dados.

        // Veja o conteúdo de CSVHEADER para compreender a ordem dos dados na linha CSV.

        return "";
    }

    public static void writePatrimonios(ArrayList<Patrimonio> patrimonios) throws IOException {
        //TODO (7) Implemente aqui um método que escreva todos os patrimonios em um arquivo no
        // formato CSV. O arquivo CSV deve ser guardado no armazenamento externo do dispositivo.
        // O nome do arquivo CSV deve seguir o formato: RELACAO_OBJETOS_<data_hora>.csv
        //      por exemplo: RELACAO_OBJETOS_20200813_135508.csv
    }
}
