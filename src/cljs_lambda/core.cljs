(ns cljs-lambda.core
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(defn -main []
  (println "Hello world!"))

(defn hello [event ctx cb]
  (cb nil (clj->js
           {
            :statusCode 200
            :headers {"Content-Type" "text/html"}
            :body "<h1>Hello, CLJS!</h1>"
            })))

(set! (.-exports js/module) #js
      {:hello hello})
