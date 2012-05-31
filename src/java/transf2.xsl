<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="//CLIENTE">
		<xsl:value-of select="CLI_ID"/>,<xsl:value-of select="CLI_SAP"/>,<xsl:value-of select="Suma_Genero_Clase"/>,<xsl:value-of select="Suma_Comportamiento_Pago"/>,<xsl:value-of select="Suma_Arraigo"/>,<xsl:value-of select="Suma_Aspectos_Diferenciadores"/>,<xsl:value-of select="Genero_Clase_Texto1"/>,<xsl:value-of select="Genero_Clase_Texto2"/>,<xsl:value-of select="Comportamiento_Pago_Texto1"/>,<xsl:value-of select="Comportamiento_Pago_Texto2"/>,<xsl:value-of select="Arraigo_Texto1"/>,<xsl:value-of select="Arraigo_Texto2"/>, <xsl:value-of select="Aspectos_Diferenciadores_Texto1"/>,<xsl:value-of select="Aspectos_Diferenciadores_Texto2"/>,<xsl:value-of select="Resultado"/>
	</xsl:template>
</xsl:stylesheet>




    







