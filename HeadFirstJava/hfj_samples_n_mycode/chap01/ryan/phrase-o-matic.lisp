(defpackage :chap01.ryan
  (:use :common-lisp)
  (:export :main))

(in-package :chap01.ryan)

(defun main ()
  (let ((word-list-one (vector "24/7" "multi-Tier" "30,000 foot" "B-to-B"
				"win-win" "front-end" "web-based" "pervasive"
				"smart" "six-sigma" "critical-path" "dynamic"))
	(word-list-two (vector "empowered" "sticky" "value-added" "oriented"
				"centric" "distributed" "clustered" "branded"
				"outside-the-box" "positioned" "networked"
				"focused" "leveraged" "aligned" "targeted"
				"shared" "cooperative" "accelerated"))
	(word-list-three (vector "process" "tipping-point" "solution"
				 "architecture" "core competency" "strategy"
				 "mindshare" "portal" "space" "vision"
				 "paradigm" "mission")))
    (format t "What we need is a ~A~%"
	    (format nil "~A ~A ~A."
		    (svref word-list-one
			   (random (length word-list-one)))
		    (svref word-list-two
			   (random (length word-list-two)))
		    (svref word-list-three
			   (random (length word-list-three)))))))