pdf:
	pdflatex biblioteca.tex

ignorando-errores:
	pdflatex -interaction=nonstopmode biblioteca.tex

bibliografia:
	pdflatex biblioteca.tex
	bibtex biblioteca.aux
	pdflatex biblioteca.tex
	pdflatex biblioteca.tex

clean:
	- rm -f *.log *.soc *.toc *.aux *.out  main.idx *.bbl *.bbg *.dvi *.blg *.lof *.nav *.snm *~

