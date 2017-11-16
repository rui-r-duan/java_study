(defclass test-object ()
  ((cnt
   :allocation :class
   :initform 0)))

(defclass test ()
  (a
   b))

(defmethod initialize-instance :after ((to test-object) &key)
  (incf (slot-value to 'cnt))
  (format t "TestObject(): ~D~%" (slot-value to 'cnt)))

(defmethod initialize-instance ((test test) &key)
  (setf (slot-value test 'a) (make-instance 'test-object))
  (format t "Test()~%")
  (setf (slot-value test 'b) (make-instance 'test-object)))