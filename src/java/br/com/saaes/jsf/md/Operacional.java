package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.dao.DAO;
import br.com.saaes.modelo.T300cursos;
import br.com.saaes.modelo.T700avaliacao;
import br.com.saaes.modelo.T700avaliacaoPK;
import br.com.saaes.modelo.T910indicadores;
import br.com.saaes.modelo.T910indicadoresPK;
import br.com.saaes.util.JPAUtil;


/**
 *
 * @author
 */
public class Operacional {

    public static final String NSA = "NAO SE APLICA";
    public static final String NAO_EXISTENTE = "NAO EXISTENTE";
    public static final String INSUFICIENTE = "INSUFICIENTE";
    public static final String SUFICIENTE = "SUFICIENTE";
    public static final String BOM_BEM = "MUITO BOM/MUITO BEM";
    public static final String EXCELENTE = "EXCELENTE";

    /**
     * Função que calcula todos os conceitos dos de acordo com as notas
     * recebidas em cada indicador
     *
     * @param t300CursoSeld
     * @return Avaliação do curso
     */
    public static T700avaliacao criaAvaliacao(T300cursos t300CursoSeld) {

        Double notaConceito2 = null;
        Double notaConceito3 = null;
        int qntInd2 = 0;
        long qntInd3 = 0 ;
        int nota=0;
        T910indicadores t910 = new T910indicadores();
        T910indicadoresPK t910PK = new T910indicadoresPK();
        t910PK.setT905ModalidadeId(t300CursoSeld.getT905ModalidadeId());
        t910PK.setT906TipoAtoId(t300CursoSeld.getT906TipoAtoId());
        t910PK.setT907TipoCursoId(t300CursoSeld.getT907TipoCursoId());

        t910 = DAO.getSingleResultFromFromNamedQuery(T910indicadores.FIND_PK, T910indicadores.class, JPAUtil.getEm(), t910PK);

        T700avaliacao novaAvaliacao = new T700avaliacao();
        T700avaliacaoPK avPk = new T700avaliacaoPK();
        avPk.setT300CursoId(t300CursoSeld);
        novaAvaliacao.setT700avaliacaoPK(avPk);
        novaAvaliacao.setDtAvaliacao(JsfUtil.getInstante());
        novaAvaliacao.setT900UsuarioId(JsfUtil.getUsuario());
        novaAvaliacao.setT905ModalidadeId(t300CursoSeld.getT905ModalidadeId());
        novaAvaliacao.setT906TipoAtoId(t300CursoSeld.getT906TipoAtoId());

        if (t910.getInd2_2()) {
            nota = indicador_2_2(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_2(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_3()) {
            nota = indicador_2_3(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_3(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_4()) {
            nota = indicador_2_4(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_4(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_5()) {
            nota = indicador_2_5(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_5(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_6()) {
            nota = indicador_2_6(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_6(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_7()) {
            nota = indicador_2_7(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_7(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_8()) {
            nota = indicador_2_8(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_8(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_9()) {
            nota = indicador_2_9(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_9(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_10()) {
            nota = indicador_2_10(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_10(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_11()) {
            nota = indicador_2_11(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_11(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_12()) {
            nota = indicador_2_12(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_12(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_13()) {
            nota = indicador_2_13(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_13(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_15()) {
            nota = indicador_2_15(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_15(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_17()) {
            nota = indicador_2_17(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_17(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_18()) {
            nota = indicador_2_18(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_18(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_19()) {
            nota = indicador_2_19(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_19(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd2_20()) {
            nota =indicador_2_20(t300CursoSeld);
            novaAvaliacao.setConceitoInd2_20(conceito(nota));
            notaConceito2 = notaConceito2 + nota;
            qntInd2++;
        }
        if (t910.getInd3_6()) {
            nota = indicador_3_6(t300CursoSeld);
            novaAvaliacao.setConceitoInd3_6(conceito(nota));
            notaConceito3 = notaConceito3 + nota;
            qntInd3++;
        }
        if (t910.getInd3_7()) {
            nota = indicador_3_7(t300CursoSeld);
            novaAvaliacao.setConceitoInd3_7(conceito(nota));
            notaConceito3 = notaConceito3 + nota;
            qntInd3++;
        }
        if (t910.getInd3_8()) {
            nota = indicador_3_8(t300CursoSeld);
            novaAvaliacao.setConceitoInd3_8(conceito(nota));
            notaConceito3 = notaConceito3 + nota;
            qntInd3++;
        }
        notaConceito2 = notaConceito2 / qntInd2;
        notaConceito3 = notaConceito3 / qntInd3;
        
        novaAvaliacao.setNotaInd2(notaConceito2);
        novaAvaliacao.setNotaInd3(notaConceito3);
        
        return novaAvaliacao;
    }
    /*
     * 2.2 
    
     */

    public static int indicador_2_2(T300cursos t300CursoSeld) {
        if (null != t300CursoSeld.getT500coordenador().getT901Atuacao()) {
            return t300CursoSeld.getT500coordenador().getT901Atuacao().getId();
        } else {
            return 0;
        }

    }

    /**
     * 2.3 Experiência do (a) coordenador (a) do curso em cursos a distância
     * experienciAno < 1 = 1 experienciAno < 2 = 2 experienciAno < 3 = 3
     * experienciAno < 4 = 4 experienciAno >= 4 = 5 NSA = 0
     *
     * @param t300CursoSeld
     * @return conceito
     */
    public static int indicador_2_3(T300cursos t300CursoSeld) {
        int nota = 0;
        if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 1){
            nota = 1;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 2){
            nota = 2;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 3){
            nota = 3;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 4){
            nota = 4;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() >= 4){
            nota = 5;
        }
        return nota;
    }
    /*
     * 2.4 Magistério superior e de gestão acadêmica do (a) coordenador (a) Mgs
     * + GsA < 1 or Mgs < 1 = 1 Mgs + GsA < 4 = 2 Mgs + GsA < 7 = 3 Mgs + GsA < 10 = 4
     * Mgs + GsA >= 10 = 5
     *
     */

    public static int indicador_2_4(T300cursos t300CursoSeld) {
        int nota = 0;
        if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 1){
            nota = 1;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 2){
            nota = 2;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 3){
            nota = 3;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() < 4){
            nota = 4;
        }else if(t300CursoSeld.getT500coordenador().getT400DocenteId().getTempoMagistExpEducacao() >= 4){
            nota = 5;
        }
        return nota;
    }
    /*
     * 2.5 Regime de trabalho do (a) coordenador (a) do curso (Reg != (parcial
     * or integral)) or (vagas anuais pretendidas/horas semanais > 25) or (h
     * Semanais < 10)  < 1 = 1
     * (Reg == (parcial or integral)) or (vagas anuais pretendidas/horas semanais
     * > 20) = 2 (Reg == (parcial or integral)) or (vagas anuais
     * pretendidas/horas semanais > 15) = 3 (Reg == (parcial or integral)) or
     * (vagas anuais pretendidas/horas semanais > 10) = 4 (Reg == (parcial or
     * integral)) or (vagas anuais pretendidas/horas semanais <= 10) = 5
     **/

    public static int indicador_2_5(T300cursos t300CursoSeld) {
        int nota = 0;
        Double vagas_hora = (double) (t300CursoSeld.getNumVagasAnuais() / t300CursoSeld.getT500coordenador().getT400DocenteId().getCargaHorariaSemanal());
        
        if((t300CursoSeld.getT500coordenador().getT400DocenteId().getT903RegimeTrabId().getId() == 3)
                || (vagas_hora > 25) ||(t300CursoSeld.getT500coordenador().getT400DocenteId().getCargaHorariaSemanal() < 10)){
            nota = 1;
        }else if((t300CursoSeld.getT500coordenador().getT400DocenteId().getT903RegimeTrabId().getId() != 3)
                || (vagas_hora > 20)){
            nota = 2;
        }else if((t300CursoSeld.getT500coordenador().getT400DocenteId().getT903RegimeTrabId().getId() != 3)
                || (vagas_hora > 15)){
            nota = 3;
        }else if((t300CursoSeld.getT500coordenador().getT400DocenteId().getT903RegimeTrabId().getId() != 3)
                || (vagas_hora > 10)){
            nota = 4;
        }else if((t300CursoSeld.getT500coordenador().getT400DocenteId().getT903RegimeTrabId().getId() != 3)
                || (vagas_hora <= 10)){
            nota = 5;
        }
        return nota;
    }
    /*
     * 2.6 Carga horária de coordenação de curso CH.semanal < 10 = 1 CH.semanal
     * < 15 = 2 CH.semanal < 20 = 3 CH.semanal < 25 = 4
     * CH.semanal >= 25 = 5
     */

    public static int indicador_2_6(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.7 Titulação do corpo docente do curso posGraduados < 15% = 1
     * posGraduados < 30% = 2 posGraduados < 50% = 3 posGraduados < 75% = 4
     * posGraduados >= 75% = 5
     */

    public static int indicador_2_7(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.8 Titulação do corpo docente do curso – percentual de doutores doutores
     * == 0% = 1 doutores =< 10% = 2 doutores =< 20% = 3 doutores =< 35% = 4
     * doutores > 35% = 5
     */

    public static int indicador_2_8(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.9 Regime de trabalho do corpo docente do curso RegTrab
     * (parcial/integral) < 20% = 1 RegTrab (parcial/integral) < 33% = 2 RegTrab
     * (parcial/integral) < 60% = 3 RegTrab (parcial/integral) < 80% = 4
     * RegTrab (parcial/integral) >= 80% = 5
     */

    public static int indicador_2_9(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.9 - Medicina Regime de trabalho do corpo docente do curso RegTrab
     * (parcial/integral) < 50% = 1 RegTrab (parcial/integral) < 60% = 2 RegTrab
     * (parcial/integral) < 70% = 3 RegTrab (parcial/integral) < 80% = 4
     * RegTrab (parcial/integral) >= 80% = 5
     */

    public static int indicador_2_9_medic(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.10 Experiência profissional do corpo docente Exp < 20% AND (bac/lic anos
     * >= 2 or tec anos >= 3) = 1 Exp < 40% AND (bac/lic anos >= 2 or tec anos
     * >= 3) = 2 Exp < 60% AND (bac/lic anos >= 2 or tec anos >= 3) = 3 Exp < 80% AND (bac/lic anos
     * >= 2 or tec anos >= 3) = 4 Exp >= 80% AND (bac/lic anos >= 2 or tec anos
     * >= 3) = 5
     */

    public static int indicador_2_10(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.10 - Medicina 2 Experiência profissional do corpo docente Medicina Exp
     * < 40% and anos == 5 = 1 Exp < 50% and anos == 5 = 2 Exp < 60% and anos ==
     * 5 = 3 Exp  < 70% and anos == 5 = 4
     * Exp >= 70% and anos == 5 = 5
     */

    public static int indicador_2_10_medic(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.11 Experiência no exercício da docência na educação básica Exp < 20% AND (Educ Basica
     * >= 3) = 1 Exp < 30% AND (Educ Basica >= 3) = 2 Exp < 40% AND (Educ Basica
     * >= 3) = 3 Exp < 50% AND (Educ Basica >= 3) = 4 Exp >= 50% AND (Educ
     * Basica >= 3) = 5
     */

    public static int indicador_2_11(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.12 Experiência de magistério superior do corpo docente Exp < 20% AND (bac/lic
     * >= 3 or tec >= 2) = 1 Exp < 40% AND (bac/lic >= 3 or tec >= 2) = 2 Exp < 60% AND (bac/lic
     * >= 3 or tec >= 2) = 3 Exp < 80% AND (bac/lic
     * >= 3 or tec >= 2) = 4 Exp >= 80% AND (bac/lic >= 3 or tec >= 2) = 5
     */

    public static int indicador_2_12(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.12 - medicina Experiência de magistério superior do corpo docente Exp < 40% AND anos
     * >= 5 = 1 Exp < 50% AND anos >= 5 = 2 Exp < 60% AND anos
     * >= 5 = 3 Exp < 70% AND anos >= 5 = 4 Exp >= 70% AND anos >= 5 = 5
     */

    public static int indicador_2_12_medic(T300cursos t300CursoSeld) {
        int nota = 0;

        return nota;
    }
    /*
     * 2.13 Relação entre o número de docentes e o número de estudantes
     * Med(docente e vagas) == 1 p + 161 = 1 Med(docente e vagas) == 1 p + 151 a
     * 160 = 2 Med(docente e vagas) == 1 p + 141 a 150 = 3 Med(docente e vagas)
     * == 1 p + 131 a 140 = 4 Med(docente e vagas) == 1 p + 130 = 5
     *
     */

    public static int indicador_2_13(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.15 Produção científica, cultural, artística ou tecnológica (Ultimos 3
     * anos) Não possui > 50% = 1 1 a 3 > 50% = 2 4 a 6 > 50% = 3 7 a 9 > 50% =
     * 4 +9 > 50% = 5
     *
     */

    public static int indicador_2_15(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }

    /**
     *
     * @param t300CursoSeld
     * @return
     */
    public static int indicador_2_17(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.18 Relação docentes e tutores - presenciais e a distância - por
     * estudante NSA para cursos presenciais. Estudante/docente_tutores > 60 = 1
     * Estudante/docente_tutores > 50 = 2 Estudante/docente_tutores > 40 = 3
     * Estudante/docente_tutores > 30 = 4 Estudante/docente_tutores <= 30 = 5
     * NSA = 0
     * obs:
     * Obrigatório para cursos a distância e presenciais, reconhecidos, que ofertam até 20% da carga horária total do curso na modalidade a distância, conforme Portaria 4.059/2004
     */

    public static int indicador_2_18(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.19
     * Responsabilidade docente pela supervisão da assistência médica (Medicina)
     * Menor 25% = 1
     * (+ 25 menor 50%) * 0,3 resp serv Clinico = 2
     * (+ 50 menor 75%) * 0,3 resp serv Clinico = 3
     * (+ 75 menor 90%) * 0,3 resp serv Clinico = 4
     * (>= 90) * 0,3 resp serv Clinico = 5 *
     */

    public static int indicador_2_19(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 2.20 Núcleo de apoio pedagógico e experiência docente (nucleo and exper
     * não previsto) or (menos de 6) = 1 (nucleo and exper > 2 anos) or (Nao
     * cobre todas areas) = 2 (nucleo and exper > 3 anos) or (cobre todas areas)
     * = 3 (nucleo and exper > 4 anos) or (cobre todas areas) = 4 (nucleo and
     * exper > 5 anos) or (cobre todas areas) = 5
     *
     * Itens avaliados: 12 Conceito: 4,4
     */

    public static int indicador_2_20(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     * 3.6 Bibliografia básica * (acervo não disponivel) or (1 exempl p +20
     * vagas anuais) or (acervo nao informatizado e não tombado ao patrimonio)
     * or (titulos p unid curricular < 3) = 1
     *
     * (acervo disponivel)
     * or (1 exempl p 15 a 20 vagas anuais)
     * or (acervo informatizado e tombado ao patrimonio)
     * or (titulos p unid curricular >= 3) = 2
     *
     * (acervo disponivel) or (1 exempl p 10 a 15 vagas anuais) or (acervo
     * informatizado e tombado ao patrimonio) or (titulos p unid curricular >=
     * 3) = 3
     *
     * (acervo disponivel) or (1 exempl p 5 a 10 vagas anuais) or (acervo
     * informatizado e tombado ao patrimonio) or (titulos p unid curricular >=
     * 3) = 4
     *
     * (acervo disponivel) or (1 exempl p menos de 5 vagas anuais) or (acervo
     * informatizado e tombado ao patrimonio) or (titulos p unid curricular >=
     * 3) = 5
     *
     * (Nos cursos que possuem acervo virtual (pelo menos 1 título virtual por
     * unidade curricular), a proporção de alunos por exemplar físico passam a
     * figurar da seguinte maneira para os conceitos 3, 4 e 5:
     *
     *
     * Conceito 3 – 13 a 19 vagas anuais
     *
     * Conceito 4 – de 6 a 13 vagas anuais
     *
     * Conceito 5 – menos de 6 vagas anuais) )
     */

    public static int indicador_3_6(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     *
     * 3.7 Bibliografia complementar
     *
     * (acervo não disponivel) or (titulos p unid curricular < 2) = 1
     *
     * (titulos p unid curricular > 2 and 2 unid por titulo) or (acesso virtual)
     * = 2
     *
     * (titulos p unid curricular > 3 and 2 unid por titulo) or (acesso virtual)
     * = 3
     *
     * (titulos p unid curricular > 4 and 2 unid por titulo) or (acesso virtual)
     * = 4
     *
     * (titulos p unid curricular > 5 and 2 unid por titulo) or (acesso virtual)
     * = 5
     */

    public static int indicador_3_7(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }
    /*
     *
     * 3.8 Periódicos especializados
     *
     *
     * Assinatura/acesso impressa ou virtual, menor que 5 títulos ou acervo não
     * atualizado3 anos = 1
     *
     * Assinatura/acesso impressa ou virtual, >= 5 < 10 títulos ou acervo não atualizado3 anos = 2
     *
     * Assinatura/acesso impressa ou virtual, >= 10 < 15 títulos ou acervo não atualizado3 anos = 3
     *
     * Assinatura/acesso impressa ou virtual, >= 15 < 20 títulos ou acervo não
     * atualizado3 anos = 4
     *
     * Assinatura/acesso impressa ou virtual, menor que 5 títulos ou acervo não
     * atualizado3 anos = 5
     *
     * (Para fins de autorização, os critérios de análise passam a figurar da
     * seguinte maneira: Conceito 1 – menor que 3 títulos Conceito 2 – maior ou
     * igual a 3 e menor que 6 Conceito 3 – maior ou igual a 6 e menor que 9
     * Conceito 4 – maior ou igual a 9 e menor que 12 Conceito 5 – maior ou
     * igual a 12))
     *     
     *
     */

    public static int indicador_3_8(T300cursos t300CursoSeld) {
        int nota = 0;
        return nota;
    }

    public static String conceito(int nota) {
        String conceito = "";
        switch (nota) {
            case 1:
                conceito = NAO_EXISTENTE;
                break;
            case 2:
                conceito = INSUFICIENTE;
                break;
            case 3:
                conceito = SUFICIENTE;
                break;
            case 4:
                conceito = BOM_BEM;
                break;
            case 5:
                conceito = EXCELENTE;
                break;
            default:
                conceito = NSA;
                break;
        }
        return conceito;
    }

    //PRESENCIAL BACHARELADO
    /*
     2.2	
    
     2.4	
     2.5	
     2.7	
     2.8	
     2.9	
     2.10	
     2.12	
     2.15	
     3.6	
     3.7	
     3.8
     */
    //PRESENCIAL TECNOLOGO
    //PRESENCIAL LICENCIATURA
    //Autorização A DISTANCIA BACHARELADO
    //Autorização A DISTANCIA TECNOLOGO
    //Autorização A DISTANCIA LICENCIATURA
    //RECONHECIMENTO PRESENCIAL BACHARELADO
    //RECONHECIMENTO PRESENCIAL TECNOLOGO
    //RECONHECIMENTO PRESENCIAL LICENCIATURA
    //RECONHECIMENTO A DISTANCIA BACHARELADO
    //RECONHECIMENTO A DISTANCIA TECNOLOGO
    //RECONHECIMENTO A DISTANCIA LICENCIATURA
    //R .RECONHECIMENTO PRESENCIAL BACHARELADO
    //R. RECONHECIMENTO PRESENCIAL TECNOLOGO
    //R. RECONHECIMENTO PRESENCIAL LICENCIATURA
    //R. RECONHECIMENTO A DISTANCIA BACHARELADO
    //R. RECONHECIMENTO A DISTANCIA TECNOLOGO
    //R. RECONHECIMENTO A DISTANCIA LICENCIATURA
    //MEDICINA
    
}
